package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Order;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.OrderService;
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
@RequestMapping("/order")
@Api(value = "订单模块", description = "订单模块")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "获取订单列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Order> list = this.orderService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
