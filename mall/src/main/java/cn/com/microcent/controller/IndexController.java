package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Cart;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/index")
@Api(value = "首页模块", description = "首页模块")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private CartService cartService;

    @ApiOperation(value = "获取首页", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response index() {
        List<Cart> list = this.cartService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("carts", list);
        return Response.success(map);
    }

}
