package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Cart;
import cn.com.microcent.entity.CheckedModel;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Cart> carts = this.cartService.findByUserId(1);
        int productCount = 0;
        BigDecimal productAmount = BigDecimal.ZERO;
        int checkedProductCount = 0;
        BigDecimal checkedProductAmount = BigDecimal.ZERO;
        for (Cart cart : carts) {
            productCount += cart.getQuantity();
            productAmount = productAmount.add(cart.getPrice().multiply(new BigDecimal(cart.getQuantity())));
            if (cart.isChecked()) {
                checkedProductCount += cart.getQuantity();
                checkedProductAmount = checkedProductAmount.add(cart.getPrice().multiply(new BigDecimal(cart.getQuantity())));
            }
        }

        Map<String, Object> mapTotal = new HashMap<>();
        mapTotal.put("productCount", productCount);
        mapTotal.put("productAmount", productAmount);
        mapTotal.put("checkedProductCount", checkedProductCount);
        mapTotal.put("checkedProductAmount", checkedProductAmount);

        Map<String, Object> map = new HashMap<>();
        map.put("carts", carts);
        map.put("cartTotal", mapTotal);
        return Response.success(map);
    }

    @ApiOperation(value = "商品选择", notes = "")
    @RequestMapping(value = "/checked", method = RequestMethod.POST)
    public Response checked(@RequestBody CheckedModel model) {
        this.cartService.updateCheck(model.getProductIds(), model.isChecked());
        return list();
    }

}
