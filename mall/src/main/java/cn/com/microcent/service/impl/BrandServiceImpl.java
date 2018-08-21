package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Brand;
import cn.com.microcent.repository.core.BrandRepository;
import cn.com.microcent.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return this.brandRepository.findAll();
    }

}
