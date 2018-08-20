package cn.com.microcent.service.impl;

import cn.com.microcent.domain.log.Log;
import cn.com.microcent.repository.log.LogRepository;
import cn.com.microcent.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public List<Log> findAll() {
        return this.logRepository.findAll();
    }

}
