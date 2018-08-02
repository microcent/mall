package cn.com.microcent.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/8/2.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Integer list() {
        return 1;
    }

}
