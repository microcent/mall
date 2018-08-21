package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Category;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.CategoryService;
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
@RequestMapping("/category")
@Api(value = "分类模块", description = "分类模块")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取分类列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Category> list = this.categoryService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
