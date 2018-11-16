package com.yalunwang.demo.validator.aop;

import com.alibaba.fastjson.JSON;

import com.summer.boot.validator.exception.ValidateRuntimeException;
import com.yalunwang.demo.validator.respone.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@RestControllerAdvice
public class ExceptionAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);
    @ExceptionHandler
    public ApiResponse<Object> handler(HttpServletRequest request, Exception ex) {
        StringBuilder errorMessage = new StringBuilder();
        Integer errorCode = 0;
        if (ex instanceof ValidateRuntimeException) {
            ValidateRuntimeException validateRuntimeException = (ValidateRuntimeException) ex;
            errorCode = validateRuntimeException.getCode();
            errorMessage.append(JSON.toJSONString(validateRuntimeException.getFailedReason()));
            LOGGER.error(errorMessage.toString());
        } else {
            //其他异常
        }
        LOGGER.error(ex.getMessage(), ex);
        return ApiResponse.fail(errorCode, errorMessage.toString());
    }
}
