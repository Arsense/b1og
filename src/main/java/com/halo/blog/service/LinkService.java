package com.halo.blog.service;

import com.halo.blog.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author tangwei
 * @date 2018/10/30 10:25
 */
public interface LinkService  {

    /**
     * 根据编号查询单个链接
     *
     * @param linkId linkId
     * @return Link
     */
    Optional<Link> findByLinkId(Long linkId);
}
