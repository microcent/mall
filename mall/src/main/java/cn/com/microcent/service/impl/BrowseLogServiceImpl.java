package cn.com.microcent.service.impl;

import cn.com.microcent.domain.log.BrowseLog;
import cn.com.microcent.repository.log.BrowseLogRepository;
import cn.com.microcent.service.BrowseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class BrowseLogServiceImpl implements BrowseLogService {

    @Autowired
    private BrowseLogRepository browseLogRepository;

    @Override
    public List<BrowseLog> findAll() {
        return this.browseLogRepository.findAll();
    }

    @Override
    public List<BrowseLog> findByUserId(long userId) {
        return this.browseLogRepository.findByUserId(userId);
    }
}
