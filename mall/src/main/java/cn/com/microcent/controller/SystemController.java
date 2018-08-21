package cn.com.microcent.controller;

import cn.com.microcent.domain.core.System;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.SystemService;
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
@RequestMapping("/system")
@Api(value = "系统模块", description = "系统模块")
public class SystemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private SystemService systemService;

    @ApiOperation(value = "获取系统列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<System> list = this.systemService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
