package com.halo.blog.service.impl;

import com.halo.blog.domain.User;
import com.halo.blog.mapper.UserRepository;
import com.halo.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/10 11:11
 */
@Service
public class UserSerivceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveByUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUser() {
        List<User> users = userRepository.findAll();
        if (users != null && users.size() > 0) {
            return users.get(0);
        } else {
            return new User();
        }
    }
}
