package cn.com.microcent.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by xingwen on 2018/8/26.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginModel {
    private String username;
    private String password;
}
