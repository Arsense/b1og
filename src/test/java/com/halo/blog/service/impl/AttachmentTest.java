package com.halo.blog.service.impl;

import com.halo.blog.BaseConfigTest;
import com.halo.blog.domain.Attachment;
import com.halo.blog.service.AttachmentService;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

/**
 * @author tangwei
 * @date 2018/10/31 14:10
 */
public class AttachmentTest extends BaseConfigTest {

    @Resource
    private AttachmentService attachmentService;

    @Test
    public void testAttachment(){
        int page = 0;
        int size = 18;
        Sort sort = new Sort(Sort.Direction.DESC, "attachId");
        //Pageable JPA特有的分页类
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Attachment> attachments = attachmentService.findAllAttachments(pageable);
        System.out.println(attachments);
    }

}
