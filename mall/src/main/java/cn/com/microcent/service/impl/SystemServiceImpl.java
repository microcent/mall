package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.System;
import cn.com.microcent.repository.core.SystemRepository;
import cn.com.microcent.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemRepository systemRepository;

    @Override
    public List<System> findAll() {
        return this.systemRepository.findAll();
    }

}
