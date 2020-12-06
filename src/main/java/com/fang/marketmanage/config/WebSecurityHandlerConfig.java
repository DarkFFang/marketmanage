package com.fang.marketmanage.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.marketmanage.entity.JwtUser;
import com.fang.marketmanage.util.JwtTokenUtil;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


/**
 * spring security处理器
 *
 * @author fang
 *
 */
@Configuration
public class WebSecurityHandlerConfig {

    /**
     * 登陆成功，返回Token
     *
     * @return
     */
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new AuthenticationSuccessHandler() {

            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
                response.setHeader(JwtTokenUtil.TOKEN_HEADER,JwtTokenUtil.createToken(jwtUser));
                RespUtil.response(response,HttpStatus.OK.value(),RespUtil.success("登录成功"));
            }
        };
    }

    /**
     * 登陆失败
     *
     * @return
     */
    @Bean
    public AuthenticationFailureHandler loginFailureHandler() {
        return new AuthenticationFailureHandler() {

            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                AuthenticationException exception) throws IOException, ServletException {
                RespUtil.response(response,HttpStatus.UNAUTHORIZED.value(),RespUtil.error("登录失败"));
            }
        };

    }

    /**
     * 未登录，返回401
     *
     * @return
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPoint() {

            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException authException) throws IOException, ServletException {
                RespUtil.response(response,HttpStatus.UNAUTHORIZED.value(),RespUtil.error("认证失效或者过期，禁止访问，请重新登录"));
            }
        };
    }

    /**
     * 退出处理
     *
     * @return
     */
    @Bean
    public LogoutSuccessHandler logoutSussHandler() {
        return new LogoutSuccessHandler() {

            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
                RespUtil.response(response,HttpStatus.OK.value(),RespUtil.error("退出成功"));
            }
        };

    }

    /**
     * 退出处理
     *
     * @return
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                RespUtil.response(httpServletResponse,HttpStatus.FORBIDDEN.value(),RespUtil.error("没有此权限，请与管理员联系"));
            }
        };
    }
}
