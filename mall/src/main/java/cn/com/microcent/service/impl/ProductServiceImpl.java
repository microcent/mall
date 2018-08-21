package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Product;
import cn.com.microcent.repository.core.ProductRepository;
import cn.com.microcent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
