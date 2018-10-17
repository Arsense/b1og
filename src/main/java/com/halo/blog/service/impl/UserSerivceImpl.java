package com.halo.blog.service.impl;

import com.halo.blog.domain.User;
import com.halo.blog.mapper.UserRepository;
import com.halo.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
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
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return new User();
        }
    }

    @Override
    public User userLoginByName(String userName, String userPass) {
        return userRepository.findByUserNameAndUserPass(userName, userPass);

    }

    @Override
    public User userLoginByEmail(String userEmail, String userPass) {
        return userRepository.findByUserEmailAndUserPass(userEmail, userPass);
    }

    @Override
    public User updateUserLoginLast(Date lastDate) {
        User user = this.findUser();
        user.setLoginLast(lastDate);
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUserNormal() {
        User user = this.findUser();
        user.setLoginEnable("true");
        user.setLoginError(0);
        user.setLoginLast(new Date());
        userRepository.save(user);
        return user;
    }

    /**
     * 增加登录错误次数
     *
     * @return 登录错误次数
     */
    @Override
    public Integer updateUserLoginError() {
        User user = this.findUser();
        user.setLoginError((user.getLoginError() == null ? 0 : user.getLoginError()) + 1);
        userRepository.save(user);
        return user.getLoginError();
    }

    @Override
    public void updateUserLoginEnable(String enable) {
        User user = this.findUser();
        user.setLoginEnable(enable);
        userRepository.save(user);
    }
}
