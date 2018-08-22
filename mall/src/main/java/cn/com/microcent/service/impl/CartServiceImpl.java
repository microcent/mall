package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Cart;
import cn.com.microcent.repository.core.CartRepository;
import cn.com.microcent.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return this.cartRepository.findAll();
    }

    @Override
    public List<Cart> findByUserId(long userId) {
        return this.cartRepository.findByUserId(userId);
    }

    @Override
    public void updateCheck(List<Long> productIds, boolean isChecked) {
        this.cartRepository.updateChecked(isChecked,productIds);
    }

}
