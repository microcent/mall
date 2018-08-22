package cn.com.microcent.service.impl;

import cn.com.microcent.core.SystemConfig;
import cn.com.microcent.domain.core.Category;
import cn.com.microcent.repository.core.CategoryRepository;
import cn.com.microcent.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Category> findIndexChannel() {
        Sort sort = new Sort(Sort.Direction.ASC, "sortNo");
        Pageable pageable = PageRequest.of(0, SystemConfig.getIndexChannelLimit(), sort);
        Page<Category> page = this.categoryRepository.findByLevel("L1", pageable);
        return page.getContent();
    }

    @Override
    public List<Category> findIndexFloor() {
        Sort sort = new Sort(Sort.Direction.ASC, "sortNo");
        Pageable pageable = PageRequest.of(0, SystemConfig.getIndexCatalogLimit(), sort);
        Page<Category> page = this.categoryRepository.findByLevel("L1", pageable);
        return page.getContent();
    }

    @Override
    public List<Category> findByParentId(long parentId) {
        return this.categoryRepository.findByParentId(parentId);
    }

    @Override
    public List<Category> findL1() {
        return this.categoryRepository.findByLevel("L1");
    }

    @Override
    public Category findById(long id) {
        return this.categoryRepository.findById(id).get();
    }
}
