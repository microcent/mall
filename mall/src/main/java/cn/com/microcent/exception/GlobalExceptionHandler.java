package cn.com.microcent.exception;

import cn.com.microcent.entity.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by xingwen on 2018/8/26.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response handlerException(Exception e) {
        if (e instanceof MallException) {
            e.printStackTrace();
            MallException exception = (MallException) e;
            return Response.failure(exception.getResponseCode(), exception.getResponseCode().getDesc());
        } else {
            return Response.failure();
        }
    }
}
