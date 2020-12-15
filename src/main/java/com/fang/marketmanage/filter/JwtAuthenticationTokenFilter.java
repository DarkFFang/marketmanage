package com.fang.marketmanage.filter;

import com.fang.marketmanage.service.UserService;
import com.fang.marketmanage.util.JwtTokenUtil;
import com.fang.marketmanage.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader(JwtTokenUtil.TOKEN_HEADER);
        if (StringUtils.isNotEmpty(authHeader)) {
            String phone = JwtTokenUtil.getPhoneFromToken(authHeader);
            Integer id = JwtTokenUtil.getUserIdFromToken(authHeader);
            if (phone != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = (UserDetails) redisUtil.get("user:" + id.toString());
                if (userDetails == null) {
                    userDetails = userService.loadUserByUsername(phone);
                    redisUtil.set("user:" + id.toString(), userDetails);
                    redisUtil.expire("user:" + id.toString(), 60 * 60 * 3);
                }
                if (JwtTokenUtil.validateToken(authHeader, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
