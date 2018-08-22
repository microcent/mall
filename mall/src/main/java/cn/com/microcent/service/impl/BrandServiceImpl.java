package cn.com.microcent.service.impl;

import cn.com.microcent.core.SystemConfig;
import cn.com.microcent.domain.core.Brand;
import cn.com.microcent.domain.core.Category;
import cn.com.microcent.repository.core.BrandRepository;
import cn.com.microcent.service.BrandService;
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
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return this.brandRepository.findAll();
    }

    @Override
    public List<Brand> findIndexBrand() {
        Sort sort = new Sort(Sort.Direction.ASC, "sortNo");
        Pageable pageable = PageRequest.of(0, SystemConfig.getIndexBrandLimit(), sort);
        Page<Brand> page = this.brandRepository.findAll(pageable);
        return page.getContent();
    }
}
