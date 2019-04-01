package com.demo.giftmoney.exceptionHandler;

import com.sug.core.platform.web.rest.exception.ExceptionUtils;
import com.sug.core.platform.web.rest.exception.SimpleErrorResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Method;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        String errorMessage = ExceptionUtils.stackTrace(throwable);
        logger.error("async method fail,method : " + method.getName());
        logger.error(errorMessage);
    }


}
