package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Brand;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.BrandService;
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
@RequestMapping("/brand")
@Api(value = "品牌模块", description = "品牌模块")
public class BrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "获取品牌列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Brand> list = this.brandService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
