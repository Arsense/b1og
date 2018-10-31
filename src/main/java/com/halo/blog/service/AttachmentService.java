package com.halo.blog.service;

import com.halo.blog.domain.Attachment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author tangwei
 * @date 2018/10/30 10:24
 */
public interface AttachmentService {

    /**
     * 查询所有附件，分页
     *
     * @param pageable pageable
     * @return Page
     */
    Page<Attachment> findAllAttachments(Pageable pageable);

}
