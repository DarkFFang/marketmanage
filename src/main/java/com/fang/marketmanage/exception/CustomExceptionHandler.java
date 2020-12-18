package com.fang.marketmanage.exception;

import com.fang.marketmanage.util.RespUtil;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        log.warn(e.getMessage());
        return RespUtil.error(e.getMessage());
    }

    @ExceptionHandler({MalformedJwtException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RespUtil jwtException(MalformedJwtException e) {
        log.warn(e.getMessage());
        return RespUtil.error(e.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RespUtil illegalArgException(IllegalArgumentException e) {
        log.warn(e.getMessage());
        return RespUtil.error(e.getMessage());
    }

    @ExceptionHandler({NullPointerException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public RespUtil nullPointerException(NullPointerException e) {
        log.warn(e.getMessage());
        return RespUtil.error(e.getMessage());
    }

}
