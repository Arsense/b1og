package com.halo.blog.service;

import com.halo.blog.domain.Comment;
import com.halo.blog.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *  <pre>
 *     评论业务逻辑接口
 * </pre>
 * @author tangwei
 * @date 2018/10/12 11:10
 */
public interface CommentService {

    /**
     * 新增评论
     *
     * @param comment comment
     */
    void saveByComment(Comment comment);

    /**
     * 查询所有的评论，用于后台管理
     *
     * @param status   status
     * @param pageable pageable
     * @return Page
     */
    Page<Comment> findAllComments(Integer status, Pageable pageable);


    /**
     * 查询所有评论，不分页
     *
     * @return List
     */
    List<Comment> findAllComments();


    /**
     * 查询最新的前五条评论
     *
     * @return List
     */
    List<Comment> findCommentsLatest();


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
