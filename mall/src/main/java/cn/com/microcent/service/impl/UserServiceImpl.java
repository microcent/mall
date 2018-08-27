package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.User;
import cn.com.microcent.entity.ResponseCode;
import cn.com.microcent.exception.MallException;
import cn.com.microcent.repository.core.UserRepository;
import cn.com.microcent.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findOne(long id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent())
            return user.get();
        return null;
    }

    @Override
    public User findById(long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public User login(String username, String password) {
        User user = this.userRepository.findByUsername(username);
        if (user == null)
            throw new MallException(ResponseCode.USER_NOT_FOUND);
        String hexPassword = DigestUtils.sha256Hex(password);
        if (!user.getPassword().equals(hexPassword))
            throw new MallException(ResponseCode.USER_ILLEGAL_PASSWORD);
        return user;
    }
}
