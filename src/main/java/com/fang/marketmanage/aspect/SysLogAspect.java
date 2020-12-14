package com.fang.marketmanage.aspect;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.JwtUser;
import com.fang.marketmanage.entity.SysLog;
import com.fang.marketmanage.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志方面
 *
 * @author fang
 * @date 2020/12/14
 */
@Aspect
@Component
public class SysLogAspect {
    /**
     * 日志记录器
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 系统日志服务
     */
    @Autowired
    private SysLogService sysLogService;

    /**
     * 日志点切
     */
    @Pointcut("@annotation(com.fang.marketmanage.annotation.CustomLog)")
    public void logPointCut() {
    }

    /**
     * 保存系统日志
     *
     * @param joinPoint 连接点
     */
    @Before("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        SysLog sysLog = new SysLog();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        CustomLog customLog = method.getAnnotation(CustomLog.class);

        if (customLog != null) {
            String operation = customLog.operation();
            sysLog.setOperation(operation);
        }

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);


        JwtUser jwtUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        sysLog.setUserId(jwtUser.getId());
        sysLog.setUserPhone(jwtUser.getPhone());
        sysLog.setUsername(jwtUser.getUsername());
        sysLog.setCreateDate(new Date());

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        sysLog.setIp(request.getRemoteAddr());
        sysLogService.addNewSysLog(sysLog);
    }
}
