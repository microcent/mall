package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Order;
import cn.com.microcent.domain.core.OrderProduct;
import cn.com.microcent.domain.core.Product;
import cn.com.microcent.entity.Response;
import cn.com.microcent.enums.OrderStatus;
import cn.com.microcent.service.OrderService;
import cn.com.microcent.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Response list(@RequestParam(value = "showType", defaultValue = "0") int showType) {
        List<Order> list = this.orderService.findByUserIdAndStatus(1, showType);
        List<Map<String, Object>> orders = new ArrayList<>();
        for (Order order : list) {
            Map<String, Object> map = new HashMap<>();
            List<OrderProduct> products = this.orderService.findByOrderId(order.getId());
            map.put("id",order.getId());
            map.put("orderNo",order.getOrderNo());
            map.put("statusText", OrderStatus.valueOf(order.getStatus()).getDesc());
            map.put("amount",order.getAmount());
            map.put("products", products);
            orders.add(map);
        }

        return Response.success(orders);
    }

}
