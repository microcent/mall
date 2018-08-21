package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Address;
import cn.com.microcent.repository.core.AddressRepository;
import cn.com.microcent.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return this.addressRepository.findAll();
    }

}
