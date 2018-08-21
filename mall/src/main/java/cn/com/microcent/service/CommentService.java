package cn.com.microcent.service;

import cn.com.microcent.domain.core.Comment;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
public interface CommentService {

    List<Comment> findAll();

}
