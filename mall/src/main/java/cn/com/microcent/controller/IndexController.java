package cn.com.microcent.controller;

import cn.com.microcent.core.SystemConfig;
import cn.com.microcent.domain.core.*;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.schema.Collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/index")
@Api(value = "首页模块", description = "首页模块")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private AdService adService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GrouponService grouponService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "获取首页", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response index() {
        List<Ad> banners = this.adService.findIndexAd();
        List<Category> channels = this.categoryService.findIndexChannel();
        List<Brand> brands = this.brandService.findIndexBrand();
        List<Groupon> grouponList = this.grouponService.findIndexGroupon();
        List<Map<String, Object>> groupons = new ArrayList<>();
        for (Groupon groupon : grouponList) {
            Map<String, Object> map = new HashMap<>();
            Product product = this.productService.findById(groupon.getProductId());
            map.put("id", groupon.getId());
            map.put("grouponMember", groupon.getDiscountMember());
            map.put("grouponPrice", product.getRetailPrice().subtract(groupon.getDiscount()));
            map.put("product", product);
            groupons.add(map);
        }
        List<Product> news = this.productService.findIndexNew();
        List<Product> hots = this.productService.findIndexHot();
        List<Topic> topics = this.topicService.findIndexTopic();
        Map<String, Object> map = new HashMap<>();
        map.put("banners", banners);
        map.put("channels", channels);
        map.put("groupons", groupons);
        map.put("brands", brands);
        map.put("news", news);
        map.put("hots", hots);
        map.put("topics", topics);
        List<Category> l1 = this.categoryService.findIndexFloor();
        List<Map<String, Object>> floors = new ArrayList<>();
        l1.stream().forEach(m -> {
            List<Category> l2 = this.categoryService.findByParentId(m.getId());
            List<Long> idList = l2.stream().map(n -> n.getId()).collect(Collectors.toList());
            List<Product> products = this.productService.findByCategory(idList);
            Map<String, Object> floor = new HashMap<>();
            floor.put("id", m.getId());
            floor.put("name", m.getName());
            floor.put("products", products);
            floors.add(floor);
        });
        map.put("floors", floors);
        return Response.success(map);
    }

}
