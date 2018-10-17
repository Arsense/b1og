package com.halo.blog.mapper;

import com.halo.blog.domain.Comment;
import com.halo.blog.domain.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangwei
 * @date 2018/10/17 10:38
 */
public interface LogsRepository extends JpaRepository<Logs, Long> {


}
