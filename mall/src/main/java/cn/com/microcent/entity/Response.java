package cn.com.microcent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private ResponseCode code;
    private String msg;
    private T data;

    public Response(ResponseCode code) {
        this.code = code;
    }

    public Response(ResponseCode code, T data) {
        this.code = code;
        this.data = data;
    }

    public Response(ResponseCode code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public final static <T> Response<T> success() {
        return new Response(ResponseCode.SUCCESS);
    }

    public final static <T> Response<T> success(T data) {
        return new Response(ResponseCode.SUCCESS, data);
    }

    public final static <T> Response<T> failure() {
        return new Response(ResponseCode.ERROR, ResponseCode.ERROR.getDesc());
    }

    public final static <T> Response<T> failure(String msg) {
        return new Response(ResponseCode.ERROR, msg);
    }

    public final static <T> Response<T> failure(ResponseCode code, String msg) {
        return new Response(code, msg);
    }

}
