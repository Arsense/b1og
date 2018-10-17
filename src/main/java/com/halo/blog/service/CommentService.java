package com.halo.blog.service;

import com.halo.blog.domain.Comment;
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
}
