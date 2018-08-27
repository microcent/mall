package cn.com.microcent.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Administrator on 2018/8/17.
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    /**/
    ERROR(-1, "失败"),

    /* 成功状态码 */
    SUCCESS(0, "成功"),

    ILLEGAL_ARGUMENT(3, "参数错误"),

    UNAUTHORIZED(401, "未认证"),
    ACCESS_DENIED(403, "未授权"),
    NOT_FOUND(404, "不存在"),

    USER_NOT_FOUND(404001, "用户不存在"),
    USER_ILLEGAL_USERNAME(404002,"用户名不正确"),
    USER_ILLEGAL_PASSWORD(404003,"用户密码不正确"),

    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    /* 参数错误：10001-19999 */
    /* 用户错误：20001-29999 */
    /* 业务错误：30001-39999 */
    /* 系统错误：40001-49999 */
    /* 数据错误：50001-59999 */
    /* 接口错误：60001-69999 */
    /* 权限错误：70001-79999 */
    @JsonValue
    private int value;
    private String desc;

}
