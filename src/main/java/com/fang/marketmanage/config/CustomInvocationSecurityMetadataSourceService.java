//package com.fang.marketmanage.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//
//@Slf4j
//@Component
//public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        return SecurityConfig.createList("ROLE_ANONYMOUS");
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return true;
//    }
//}
