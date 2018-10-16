package com.halo.blog.mapper;

import com.halo.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangwei
 * @date 2018/10/12 11:13
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
