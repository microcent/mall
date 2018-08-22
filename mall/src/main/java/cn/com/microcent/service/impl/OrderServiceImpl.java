package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Order;
import cn.com.microcent.domain.core.OrderProduct;
import cn.com.microcent.repository.core.OrderProductRepository;
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

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public List<Order> findByUserIdAndStatus(long userId, int status) {
        return this.orderRepository.findByUserIdAndStatus(userId, status);
    }

    @Override
    public List<OrderProduct> findByOrderId(long orderId) {
        return this.orderProductRepository.findByOrderId(orderId);
    }
}
