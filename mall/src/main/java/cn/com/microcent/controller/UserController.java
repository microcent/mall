package cn.com.microcent.controller;

import cn.com.microcent.domain.core.User;
import cn.com.microcent.entity.Response;
import cn.com.microcent.entity.ResponseCode;
import cn.com.microcent.entity.ViewUser;
import cn.com.microcent.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "")
    @ApiResponses({
            @ApiResponse(code = 500, message = "接口异常"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<User> list = this.userService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据id来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "java.lang.Long", name = "id", value = "用户编号", paramType = "path", required = true)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response user(@PathVariable Long id) {
        User user = this.userService.findOne(id);
        if (user != null) {
            ViewUser viewUser = new ViewUser();
            viewUser.fromEntity(user);
            return Response.success(viewUser);
        } else {
            return Response.failure(ResponseCode.USER_NOT_FOUND.getDesc());
        }
    }

}
