package com.fang.marketmanage.exception;

import com.fang.marketmanage.util.RespUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RespUtil sqlException(SQLIntegrityConstraintViolationException e) {
        return RespUtil.error("数据库未知错误");
    }

}
