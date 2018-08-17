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
    SUCCESS(200, "成功");

    @JsonValue
    private int value;
    private String desc;

}
