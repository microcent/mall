package cn.com.microcent.service;

import cn.com.microcent.domain.core.Topic;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
public interface TopicService {

    List<Topic> findIndexTopic();

    Topic findById(long id);

}
