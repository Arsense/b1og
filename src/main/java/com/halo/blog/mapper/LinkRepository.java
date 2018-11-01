package com.halo.blog.mapper;

import com.halo.blog.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangwei
 * @date 2018/10/31 18:35
 */
public interface LinkRepository extends JpaRepository<Link, Long> {
}
