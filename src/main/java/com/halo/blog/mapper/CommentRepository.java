package com.halo.blog.mapper;

import com.halo.blog.domain.Comment;
import com.halo.blog.domain.Post;
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

    /**
     * 根据文章和评论状态查询评论 不分页
     *
     * @param post   post
     * @param status status
     * @return List
     */
    List<Comment> findCommentsByPostAndCommentStatus(Post post, Integer status);


    /**
     * 根据文章和评论状态（为不查询的）查询评论 不分页
     *
     * @param post   post
     * @param status status
     * @return List
     */
    List<Comment> findCommentsByPostAndCommentStatusNot(Post post, Integer status);
}
