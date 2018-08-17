package cn.com.microcent.controller;

import cn.com.microcent.entity.Response;
import cn.com.microcent.model.User;
import cn.com.microcent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/info")
    public Response info(@RequestParam(value = "name", defaultValue = "World") String name) {
        List<User> list = repository.findAll();
        return Response.success(list);
    }

}
