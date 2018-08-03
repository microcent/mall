package cn.com.microcent.service;

import cn.com.microcent.mapper.UserMapper;
import cn.com.microcent.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/8/3.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private UserMapper mapper;

    public List<User> findAll(){
        List<User> list=mapper.selectAll();
        return list;
    }

}
