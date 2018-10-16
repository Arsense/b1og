package com.halo.blog.service.impl;

import com.halo.blog.domain.Comment;
import com.halo.blog.mapper.CommentRepository;
import com.halo.blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
