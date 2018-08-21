package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Admin;
import cn.com.microcent.repository.core.AdminRepository;
import cn.com.microcent.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return this.adminRepository.findAll();
    }

}
