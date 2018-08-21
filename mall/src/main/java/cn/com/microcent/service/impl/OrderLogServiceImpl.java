package cn.com.microcent.service.impl;

import cn.com.microcent.domain.log.OrderLog;
import cn.com.microcent.repository.log.OrderLogRepository;
import cn.com.microcent.service.OrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class OrderLogServiceImpl implements OrderLogService {

    @Autowired
    private OrderLogRepository orderLogRepository;

    @Override
    public List<OrderLog> findAll() {
        return this.orderLogRepository.findAll();
    }

}
