package com.halo.blog.service.impl;

import com.halo.blog.domain.Comment;
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
}
