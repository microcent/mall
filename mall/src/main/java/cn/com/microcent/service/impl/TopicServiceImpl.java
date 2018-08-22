package cn.com.microcent.service.impl;

import cn.com.microcent.core.SystemConfig;
import cn.com.microcent.domain.core.Ad;
import cn.com.microcent.domain.core.Topic;
import cn.com.microcent.repository.core.AdRepository;
import cn.com.microcent.repository.core.TopicRepository;
import cn.com.microcent.service.AdService;
import cn.com.microcent.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository adRepository;

    @Override
    public List<Topic> findIndexTopic() {
        Sort sort = new Sort(Sort.Direction.ASC, "createTime");
        Pageable pageable = PageRequest.of(0, SystemConfig.getIndexTopicLimit(), sort);
        Page<Topic> page = this.adRepository.findAll(pageable);
        return page.getContent();
    }

}
