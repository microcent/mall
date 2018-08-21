package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Ad;
import cn.com.microcent.domain.core.Brand;
import cn.com.microcent.repository.core.AdRepository;
import cn.com.microcent.repository.core.BrandRepository;
import cn.com.microcent.service.AdService;
import cn.com.microcent.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Override
    public List<Ad> findTop5() {
        return this.adRepository.findAll();
    }

}
