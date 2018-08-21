package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Region;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.RegionService;
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
@RequestMapping("/region")
@Api(value = "区域模块", description = "区域模块")
public class RegionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegionController.class);

    @Autowired
    private RegionService regionService;

    @ApiOperation(value = "获取区域列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Region> list = this.regionService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
