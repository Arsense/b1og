package com.halo.blog.service.impl;

import com.halo.blog.domain.Link;
import com.halo.blog.mapper.LinkRepository;
import com.halo.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author tangwei
 * @date 2018/10/31 18:34
 */
public class LinkServiceImpl implements LinkService{

    @Autowired
    private LinkRepository linkRepository;


    @Override
    public Optional<Link> findByLinkId(Long linkId) {
        return linkRepository.findById(linkId);
    }
}
