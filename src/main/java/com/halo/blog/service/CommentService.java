package com.halo.blog.service;

import com.halo.blog.domain.Comment;

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
}
