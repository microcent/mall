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

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/cart")
@Api(value = "购物车模块", description = "购物车模块")
public class CartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @ApiOperation(value = "获取购物车列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Cart> list = this.cartService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
