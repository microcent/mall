package cn.com.microcent.controller;

import cn.com.microcent.domain.core.Comment;
import cn.com.microcent.domain.core.Topic;
import cn.com.microcent.entity.Response;
import cn.com.microcent.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
@RequestMapping("/comment")
@Api(value = "评论模块", description = "评论模块")
public class CommentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "获取评论列表", notes = "")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Response list() {
        List<Comment> list = this.commentService.findAll();
        LOGGER.info("list size:{}", list.size());
        return Response.success(list);
    }

}
