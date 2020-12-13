package com.chigua.core.log.aspect;

import com.alibaba.fastjson.JSON;
import com.chigua.core.tool.utils.IPUtils;
import com.chigua.core.tool.utils.UUIDGenerator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.log.aspect.WebLogAspect
 *
 * @author Mr.zhou <ijiami.cn>
 * @description 日志切面(打印全局请求与返回接口)
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/09 - 14:30
 */
@Aspect
@Component
public class WebLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    ThreadLocal<String> reqId = new ThreadLocal<>();

    //如果你需要拦截指定package指定规则名称的方法，可以使用表达式execution(...)
    @Pointcut("execution(public * com.chigua.*.*.*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        reqId.set(UUIDGenerator.gen8UUID());
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(null!=attributes){
            HttpServletRequest request = attributes.getRequest();
            // 记录下请求内容,使用{}占位符。避免字符串连接操作，减少String对象（不可变）带来的内存开销
            LOGGER.info("<<<<<<<<<<<<<<<<<<<<<<<<");
            LOGGER.info("reqId : {}, URL : {}", reqId.get().substring(0,6), request.getRequestURL().toString());
            LOGGER.info("reqId : {}, HTTP_METHOD : {}", reqId.get().substring(0,6), request.getMethod());
            LOGGER.info("reqId : {}, IP : {}", reqId.get().substring(0,6), IPUtils.getIpAddr(request));
            LOGGER.info("reqId : {}, CLASS_METHOD : {}", reqId.get().substring(0,6), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            LOGGER.info("reqId : {}, ARGS : {}", reqId.get().substring(0,6), Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        LOGGER.info("reqId : {}, RESPONSE : {}", reqId.get().substring(0,6), JSON.toJSONString(ret));
        LOGGER.info("reqId : {}, SPEND TIME : {} MS", reqId.get().substring(0,6),(System.currentTimeMillis() - startTime.get()));
        LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
