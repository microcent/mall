package cn.com.microcent.service.impl;

import cn.com.microcent.core.SystemConfig;
import cn.com.microcent.domain.core.Brand;
import cn.com.microcent.domain.core.Product;
import cn.com.microcent.repository.core.ProductRepository;
import cn.com.microcent.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> findIndexNew() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, SystemConfig.getIndexNewLimit(), sort);
        Page<Product> page = this.productRepository.findByIsNew(true, pageable);
        return page.getContent();
    }

    @Override
    public List<Product> findIndexHot() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, SystemConfig.getIndexHotLimit(), sort);
        Page<Product> page = this.productRepository.findByIsHot(true, pageable);
        return page.getContent();
    }

    @Override
    public List<Product> findByCategory(List<Long> idList) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, SystemConfig.getIndexCatalogMoreLimit(), sort);
        Page<Product> page = this.productRepository.findByCategoryIdIn(idList, pageable);
        return page.getContent();
    }

    @Override
    public List<Product> findByCategoryId(long categoryId) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Product> page = this.productRepository.findByCategoryId(categoryId, pageable);
        return page.getContent();
    }

    @Override
    public long count() {
        return this.productRepository.count();
    }

    @Override
    public Product findById(long id) {
        return this.productRepository.findById(id).get();
    }
}
