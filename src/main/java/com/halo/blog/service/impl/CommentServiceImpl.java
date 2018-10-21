package com.halo.blog.service.impl;

import com.halo.blog.domain.Comment;
import com.halo.blog.domain.Post;
import com.halo.blog.mapper.CommentRepository;
import com.halo.blog.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/12 11:10
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentRepository commentRepository;
    @Override
    public void saveByComment(Comment comment) {
        commentRepository.save(comment);

    }

    @Override
    public Page<Comment> findAllComments(Integer status, Pageable pageable) {
        return null;
    }

    @Override
    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findCommentsLatest() {
        return commentRepository.findTopFive();
    }

    @Override
    public List<Comment> findCommentsByPostAndCommentStatus(Post post, Integer status) {
        return commentRepository.findCommentsByPostAndCommentStatus(post, status);

    }


    /**
     * 根据文章和评论状态（为不查询的）查询评论 不分页
     *
     * @param post   post
     * @param status status
     * @return List
     */
    @Override
    public List<Comment> findCommentsByPostAndCommentStatusNot(Post post, Integer status) {
        return commentRepository.findCommentsByPostAndCommentStatusNot(post, status);
    }
}
