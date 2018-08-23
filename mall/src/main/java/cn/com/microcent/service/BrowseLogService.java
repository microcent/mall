package cn.com.microcent.service;

import cn.com.microcent.domain.log.BrowseLog;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
public interface BrowseLogService {

    List<BrowseLog> findAll();

    List<BrowseLog> findByUserId(long userId);

}
