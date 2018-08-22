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
@RequestMapping("/category")
@Api(value = "分类模块", description = "分类模块")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取分类列表", notes = "")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response list(@PathVariable Long id) {
        // 当前一级分类目录
        Category currentCategory = categoryService.findById(id);

        // 当前一级分类目录对应的二级分类目录
        List<Category> brotherCategory = null;
        if (currentCategory.getParentId() == 0) {
            brotherCategory = this.categoryService.findByParentId(currentCategory.getId());
            currentCategory = brotherCategory.size() > 0 ? brotherCategory.get(0) : currentCategory;
        } else {
            brotherCategory = this.categoryService.findByParentId(currentCategory.getParentId());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("currentCategory", currentCategory);
        map.put("brotherCategory", brotherCategory);
        return Response.success(map);
    }

}
