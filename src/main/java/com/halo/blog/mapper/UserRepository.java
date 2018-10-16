package com.halo.blog.mapper;

import com.halo.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangwei
 * @date 2018/10/10 11:11
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据用户名和密码查询
     *
     * @param userName userName
     * @param userPass userPass
     * @return User
     */
    User findByUserNameAndUserPass(String userName, String userPass);

}
