package com.lmtech.facadeaop.interceptor;


import com.lmtech.common.ContextManager;
import com.lmtech.util.LoggerManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SerialNumberInterceptor extends InterceptorBase implements Interceptor {

    public void invoke(ProceedingJoinPoint pjp) {
        String serialNumber = ContextManager.buildSerialNumber();
        LoggerManager.info("生成业务流水号：" + serialNumber);
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public int getOrder() {
        return order_high;
    }
}
