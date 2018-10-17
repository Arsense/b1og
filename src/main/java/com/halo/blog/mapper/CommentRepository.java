package com.halo.blog.mapper;

import com.halo.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/12 11:13
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    /**
     * 查询最新的前五条评论
     *
     * @return List
     */
    @Query(value = "SELECT * FROM comment ORDER BY comment_date DESC LIMIT 5", nativeQuery = true)
    List<Comment> findTopFive();
}
