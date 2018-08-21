package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Region;
import cn.com.microcent.repository.core.RegionRepository;
import cn.com.microcent.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> findAll() {
        return this.regionRepository.findAll();
    }

}
