package cn.com.microcent.service;

import cn.com.microcent.domain.log.OrderLog;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
public interface OrderLogService {

    List<OrderLog> findAll();

}
