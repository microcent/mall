package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Product;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/product")
@Api(value = "商品模块", description = "商品模块")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取商品列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Product> list = this.productService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

    @ApiOperation(value = "获取商品列表", notes = "")
    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public Response list(@PathVariable Long categoryId) {
        return Response.success(this.productService.findByCategoryId(categoryId));
    }

    @ApiOperation(value = "获取商品总数", notes = "")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Response count() {
        return Response.success(this.productService.count());
    }

}
