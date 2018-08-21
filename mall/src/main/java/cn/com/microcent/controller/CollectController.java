package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Collect;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.CollectService;
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
@RequestMapping("/collect")
@Api(value = "收藏模块", description = "收藏模块")
public class CollectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CollectController.class);

    @Autowired
    private CollectService collectService;

    @ApiOperation(value = "获取收藏列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Collect> list = this.collectService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
