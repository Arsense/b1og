package com.halo.blog.service;

import com.halo.blog.domain.User;

/**
 * <pre>
 *     用户业务逻辑接口
 * </pre>
 * @author tangwei
 * @date 2018/10/10 11:09
 */
public interface UserService {

    /**
     * 保存个人资料
     *
     * @param user user
     */
    void saveByUser(User user);

    /**
     * 查询所有用户
     *
     * @return User
     */
    User findUser();
}
