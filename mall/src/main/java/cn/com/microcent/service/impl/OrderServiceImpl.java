package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Order;
import cn.com.microcent.repository.core.OrderRepository;
import cn.com.microcent.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

}
