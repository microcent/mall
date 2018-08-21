package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Comment;
import cn.com.microcent.repository.core.CommentRepository;
import cn.com.microcent.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

}
