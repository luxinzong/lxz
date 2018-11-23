package com.suma.lxz.aop;

import com.suma.lxz.annotation.LogEnable;
import com.suma.lxz.log.ILogManager;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import net.bytebuddy.asm.Advice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @Author: luxinzong
 * @Date: 2018/11/23
 * @description
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    private LoggingOption.LoggerInfo logInfoGeneration;

    @Autowired
    private ILogManager logManager;

    @Pointcut("execution(* com.suma.lxz.service..*.*(..))")
    public void managerLogPoint() {

    }

    @Around("managerLogPoint()")
    public Object aroundManagerLogPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        //打印节点信息
        printJoinPoint(joinPoint);
        Class target = joinPoint.getTarget().getClass();

        //获取LogEnable
        LogEnable logEnable = (LogEnable) target.getAnnotation(LogEnable.class);
        if (logEnable == null || !logEnable.logEnable()) {

        }
        return joinPoint.proceed();
    }

    /**
     * 打印节点信息
     * @param point
     */
    private void printJoinPoint(ProceedingJoinPoint point) {
        System.out.println("==============");
        System.out.println("目标方法为：" + point.getSignature().getName());
        System.out.println("目标方法所属类的简单类名：" + point.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名：" + point.getSignature().getDeclaringTypeName());
        System.out.println("目标方法的类型：" + Modifier.toString(point.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = point.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数为：" + args[i]);
        }
        //point.getTarget() 实际类，通常为point.getSignature().getDeclaringType()的实现类
        System.out.println("被代理的对象：" + point.getTarget());
        System.out.println("代理对象自己：" + point.getThis());
        System.out.println("=========11");
        for (Method method : point.getSignature().getDeclaringType().getMethods()) {
            System.out.println("==:" + method);
            System.out.println("getAnnotations == :" + Arrays.toString(method.getAnnotations()));
        }
    }

}

















