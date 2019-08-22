package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 切面 打印请求、返回参数信息
 *
 * @author lifq
 * <p>
 * 2018年10月18日 上午10:56:49
 */
@Aspect // 定义一个切面
@Configuration
public class LogRecordAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

    // 定义切点Pointcut
    @Pointcut("execution(* com.example.demo.controller.*Controller.*(..))")
    public void excudeService() {
    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String method = request.getMethod();
        String uri = request.getRequestURI();
        logger.info("***************************************************");
        logger.info("请求开始, URI: {}, method: {}", uri, method);
        long start = System.currentTimeMillis();

        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        logger.info("请求结束, URI: {},耗时={}", uri, System.currentTimeMillis() - start);
        return result;
    }
}
