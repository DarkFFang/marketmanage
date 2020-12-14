package com.fang.marketmanage.exception;

import com.fang.marketmanage.util.RespUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 数据库语句出现错误.
 * @author fang
 * @since 2020/12/14
 */
@RestControllerAdvice
public class CustomExceptionHandler {
    /**
     *检测数据库语句错误返回错误
     * @param e
     * @return
     */
    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RespUtil sqlException(SQLIntegrityConstraintViolationException e) {
        return RespUtil.error(e.getMessage());
    }

}
