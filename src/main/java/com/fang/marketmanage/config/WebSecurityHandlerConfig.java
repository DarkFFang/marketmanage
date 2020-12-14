package com.fang.marketmanage.config;

import com.fang.marketmanage.entity.JwtUser;
import com.fang.marketmanage.entity.SysLog;
import com.fang.marketmanage.service.SysLogService;
import com.fang.marketmanage.util.JwtTokenUtil;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


/**
 * 网络安全处理程序配置
 * spring security处理器
 *
 * @author fang
 * @date 2020/12/14
 */
@Configuration
public class WebSecurityHandlerConfig {
    /**
     * 系统日志服务
     */
    @Autowired
    private SysLogService sysLogService;

    /**
     * 登录成功处理程序
     * 登陆成功，返回Token
     *
     * @return {@link AuthenticationSuccessHandler}
     */
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new AuthenticationSuccessHandler() {

            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                JwtUser jwtUser = (JwtUser) authentication.getPrincipal();

                SysLog sysLog = new SysLog();
                sysLog.setUserId(jwtUser.getId());
                sysLog.setUserPhone(jwtUser.getPhone());
                sysLog.setUsername(jwtUser.getUsername());
                sysLog.setIp(request.getRemoteAddr());
                sysLog.setMethod("Login");
                sysLog.setCreateDate(new Date());
                sysLog.setOperation("登录");
                sysLogService.addNewLoginLog(sysLog);

                response.setHeader(JwtTokenUtil.TOKEN_HEADER, JwtTokenUtil.createToken(jwtUser));
                RespUtil.response(response, HttpStatus.OK.value(), RespUtil.success("登录成功"));
            }
        };
    }

    /**
     * 登录失败处理程序
     * 登陆失败
     *
     * @return {@link AuthenticationFailureHandler}
     */
    @Bean
    public AuthenticationFailureHandler loginFailureHandler() {
        return new AuthenticationFailureHandler() {

            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                AuthenticationException exception) throws IOException, ServletException {
                RespUtil.response(response, HttpStatus.UNAUTHORIZED.value(), RespUtil.error("登录失败"));
            }
        };

    }

    /**
     * 认证入口点
     * 未登录，返回401
     *
     * @return {@link AuthenticationEntryPoint}
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPoint() {

            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException authException) throws IOException, ServletException {
                RespUtil.response(response, HttpStatus.UNAUTHORIZED.value(), RespUtil.error("认证失效或者过期，禁止访问，请重新登录"));
            }
        };
    }

    /**
     * 注销suss处理程序
     * 退出处理
     *
     * @return {@link LogoutSuccessHandler}
     */
    @Bean
    public LogoutSuccessHandler logoutSussHandler() {
        return new LogoutSuccessHandler() {

            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
                RespUtil.response(response, HttpStatus.OK.value(), RespUtil.error("退出成功"));
            }
        };

    }

    /**
     * 拒绝访问处理程序
     * 退出处理
     *
     * @return {@link AccessDeniedHandler}
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                RespUtil.response(httpServletResponse, HttpStatus.FORBIDDEN.value(), RespUtil.error("没有此权限，请与管理员联系"));
            }
        };
    }
}
