package com.halo.blog.service.impl;

import com.halo.blog.domain.Attachment;
import com.halo.blog.mapper.AttachmentRepository;
import com.halo.blog.service.AttachmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author tangwei
 * @date 2018/10/30 10:26
 */
@Service
public class AttachmentServiceImpl implements AttachmentService{


    @Resource
    private AttachmentRepository attachmentRepository;

    @Override
    public Page<Attachment> findAllAttachments(Pageable pageable) {
        return attachmentRepository.findAll(pageable);
    }


}
