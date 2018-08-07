package cn.com.microcent.controller;

import cn.com.microcent.model.User;
import cn.com.microcent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/8/2.
 */
@RestController
@RequestMapping(value = "/user")
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        List<User> list=userService.findAll();
        return list;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return driverClassName;
    }

}
