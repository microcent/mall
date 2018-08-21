package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Admin;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/admin")
@Api(value = "管理员模块", description = "管理员模块")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "获取管理员列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Admin> list = this.adminService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
