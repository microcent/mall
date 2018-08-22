package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Collect;
import cn.com.microcent.domain.core.Product;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.CollectService;
import cn.com.microcent.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/collect")
@Api(value = "收藏模块", description = "收藏模块")
public class CollectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CollectController.class);

    @Autowired
    private CollectService collectService;

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取收藏列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Collect> list = this.collectService.findByUserId(1);
        List<Map<String, Object>> collects = new ArrayList<>();
        for (Collect collect : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", collect.getId());
            map.put("type", collect.getType());
            map.put("valueId", collect.getValueId());

            Product product = this.productService.findById(collect.getValueId());
            map.put("name", product.getName());
            map.put("brief", product.getBrief());
            map.put("imageUrl", product.getImageUrl());
            map.put("retailPrice", product.getRetailPrice());
            collects.add(map);
        }
        return Response.success(collects);
    }

}
