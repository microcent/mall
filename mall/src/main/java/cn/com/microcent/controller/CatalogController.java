package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Category;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/catalog")
@Api(value = "分类模块", description = "商品目录模块")
public class CatalogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取商品目录列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list(@RequestParam(name = "id", required = false) Long id) {
        // 所有一级分类目录
        List<Category> categories = this.categoryService.findL1();
        // 当前一级分类目录
        Category currentCategory = null;
        if (id != null) {
            currentCategory = categoryService.findById(id);
        } else {
            currentCategory = categories.get(0);
        }
        // 当前一级分类目录对应的二级分类目录
        List<Category> currentSubCategory = null;
        if (currentCategory != null) {
            currentSubCategory = this.categoryService.findByParentId(currentCategory.getId());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("categories", categories);
        map.put("currentCategory", currentCategory);
        map.put("currentSubCategory", currentSubCategory);
        return Response.success(map);
    }

    @ApiOperation(value = "获取商品子目录列表", notes = "")
    @RequestMapping(value = "/current/{id}", method = RequestMethod.GET)
    public Response current(@PathVariable Long id) {
        // 当前一级分类目录
        Category currentCategory = currentCategory = categoryService.findById(id);
        // 当前一级分类目录对应的二级分类目录
        List<Category> currentSubCategory = null;
        if (currentCategory != null) {
            currentSubCategory = this.categoryService.findByParentId(currentCategory.getId());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("currentCategory", currentCategory);
        map.put("currentSubCategory", currentSubCategory);
        return Response.success(map);
    }

}
