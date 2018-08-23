package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Comment;
import cn.com.microcent.domain.core.Topic;
import cn.com.microcent.domain.core.User;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.CommentService;
import cn.com.microcent.service.TopicService;
import cn.com.microcent.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取专题详情", notes = "")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Response detail(@PathVariable Long id) {
        Topic topic = this.topicService.findById(id);
        return Response.success(topic);
    }

    @ApiOperation(value = "获取相关专题详情", notes = "")
    @RequestMapping(value = "/related/{id}", method = RequestMethod.GET)
    public Response related(@PathVariable Long id) {
        List<Topic> topics = this.topicService.findByIdNot(id);
        return Response.success(topics);
    }

    @ApiOperation(value = "获取相关专题详情", notes = "")
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public Response comment(@PathVariable Long id) {
        List<Comment> list = this.commentService.findTopicCommect(id);
        List<Map<String, Object>> comments = new ArrayList<>();
        for (Comment comment : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("comment", comment);
            User user = this.userService.findById(comment.getUserId());
            map.put("user", user);
            comments.add(map);
        }
        return Response.success(comments);
    }

}
