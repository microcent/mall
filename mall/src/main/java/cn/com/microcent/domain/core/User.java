package cn.com.microcent.domain.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/17.
 */
@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "gender")
    private int gender;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "level")
    private int level;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "status")
    private int status;

    @Column(name = "wx_openid")
    private String wxOpenid;

    @Column(name = "last_login_time")
    private String lastLoginTime;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "create_time")
    private Date createTime;

}
