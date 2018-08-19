package cn.com.microcent.entity;

import cn.com.microcent.model.core.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by xingwen on 2018/8/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewUser {

    private long id;
    private String username;
    private String password;
    private Date createTime;

    public void fromEntity(User user) {
        if (user != null) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.createTime = user.getCreateTime();
        }
    }

}
