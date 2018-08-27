package cn.com.microcent.service;

import cn.com.microcent.domain.core.User;
import cn.com.microcent.exception.MallException;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
public interface UserService {

    List<User> findAll();

    User findOne(long id);

    User findById(long id);

    User login(String username, String password);

}
