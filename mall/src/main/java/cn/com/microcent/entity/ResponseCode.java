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

    ERROR(-1, "错误"),
    SUCCESS(200, "成功"),

    USER_NOT_FOUND(404001, "用户不存在");

    @JsonValue
    private int value;
    private String desc;

}
