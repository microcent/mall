package cn.com.microcent.service;

import cn.com.microcent.domain.core.Ad;
import cn.com.microcent.domain.core.Brand;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
public interface AdService {

    List<Ad> findTop5();

}
