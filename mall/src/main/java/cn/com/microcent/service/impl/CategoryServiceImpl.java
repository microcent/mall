package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Category;
import cn.com.microcent.repository.core.CategoryRepository;
import cn.com.microcent.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
    
}
