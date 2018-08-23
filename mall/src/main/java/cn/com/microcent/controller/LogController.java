package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Product;
import cn.com.microcent.domain.log.BrowseLog;
import cn.com.microcent.entity.Response;
import cn.com.microcent.domain.log.Log;
import cn.com.microcent.repository.log.LogRepository;
import cn.com.microcent.service.BrowseLogService;
import cn.com.microcent.service.LogService;
import cn.com.microcent.service.ProductService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/log")
@Api(value = "日志模块", description = "日志模块")
public class LogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;

    @Autowired
    private BrowseLogService browseLogService;

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取日志列表", notes = "")
    @ApiResponses({
            @ApiResponse(code = 500, message = "接口异常"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Log> list = this.logService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

    @ApiOperation(value = "获取浏览日志列表", notes = "")
    @RequestMapping(value = "/browse", method = RequestMethod.GET)
    public Response browse() {
        List<BrowseLog> list = this.browseLogService.findByUserId(1);
        List<Map<String, Object>> logs = new ArrayList<>();
        for (BrowseLog log : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", log.getId());
            map.put("createTime", log.getCreateTime());
            Product product = this.productService.findById(log.getProductId());
            map.put("productId", product.getId());
            map.put("name", product.getName());
            map.put("brief", product.getBrief());
            map.put("imageUrl", product.getImageUrl());
            map.put("retailPrice", product.getRetailPrice());
            logs.add(map);
        }
        return Response.success(logs);
    }

}
