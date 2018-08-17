package cn.com.microcent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/8/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private ResponseCode code;
    private Object data;
    private String msg;

    public Response(ResponseCode code) {
        this.code = code;
    }

    public final static Response success() {
        return new Response(ResponseCode.SUCCESS);
    }

    public final static Response failure() {
        return new Response(ResponseCode.ERROR);
    }

    public final static <T> Response success(T t) {
        return new Response(ResponseCode.SUCCESS).data(t);
    }

    public final static Response failure(String msg) {
        return new Response(ResponseCode.ERROR).msg(msg);
    }

    public <T> Response data(T t) {
        this.data = t;
        return this;
    }

    public Response msg(String msg) {
        this.msg = msg;
        return this;
    }

}
