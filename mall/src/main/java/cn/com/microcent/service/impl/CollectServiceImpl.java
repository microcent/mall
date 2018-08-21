package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Collect;
import cn.com.microcent.repository.core.CollectRepository;
import cn.com.microcent.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectRepository collectRepository;

    @Override
    public List<Collect> findAll() {
        return this.collectRepository.findAll();
    }

}
