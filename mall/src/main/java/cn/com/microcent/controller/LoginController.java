package cn.com.microcent.controller;

import cn.com.microcent.domain.core.User;
import cn.com.microcent.entity.LoginModel;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户模块", description = "用户模块")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录", notes = "")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody LoginModel model) {
        User user = this.userService.login(model.getUsername(), model.getPassword());
        return Response.success(user);
    }

}
