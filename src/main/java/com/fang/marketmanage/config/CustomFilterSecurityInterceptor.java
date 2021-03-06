//package com.fang.marketmanage.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.SecurityMetadataSource;
//import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
//import org.springframework.security.access.intercept.InterceptorStatusToken;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//@Component
//public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
//
//    @Autowired
//    private FilterInvocationSecurityMetadataSource securityMetadataSource;
//
//    @Autowired
//    public void setAccessDecisionManager(CustomAccessDecisionManager accessDecisionManager) {
//        super.setAccessDecisionManager(accessDecisionManager);
//    }
//
//    @Override
//    public Class<?> getSecureObjectClass() {
//        return FilterInvocation.class;
//    }
//
//    @Override
//    public SecurityMetadataSource obtainSecurityMetadataSource() {
//        return this.securityMetadataSource;
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        FilterInvocation filterInvocation = new FilterInvocation(servletRequest, servletResponse, filterChain);
//        InterceptorStatusToken token = super.beforeInvocation(filterInvocation);
//        try {
//            filterInvocation.getChain().doFilter(filterInvocation.getRequest(),filterInvocation.getResponse());
//        }finally {
//            super.afterInvocation(token, null);
//        }
//    }
//}
