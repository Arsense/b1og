package com.halo.blog.mapper;

import com.halo.blog.domain.Attachment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangwei
 * @date 2018/10/30 11:07
 */
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    /**
     * 查询所有附件，分页
     *
     * @param pageable pageable
     * @return Page
     */
    @Override
    Page<Attachment> findAll(Pageable pageable);
}
