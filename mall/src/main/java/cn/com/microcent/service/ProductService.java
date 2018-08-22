package cn.com.microcent.service;

import cn.com.microcent.domain.core.Product;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
public interface ProductService {

    List<Product> findAll();

    List<Product> findIndexNew();

    List<Product> findIndexHot();

    List<Product> findByCategory(List<Long> idList);

    List<Product> findByCategoryId(long categoryId);

    long count();

    Product findById(long id);

}
