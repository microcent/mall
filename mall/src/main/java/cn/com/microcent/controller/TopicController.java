package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Topic;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/topic")
@Api(value = "专题模块", description = "专题模块")
public class TopicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "获取专题详情", notes = "")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Response detail(@PathVariable Long id) {
        Topic topic = this.topicService.findById(id);
        return Response.success(topic);
    }

}
