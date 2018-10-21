package com.halo.blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tangwei
 * @date 2018/10/21 23:50
 */
@Controller
@RequestMapping(value = "/admin/tag")
public class TagController {
    /**
     * 渲染标签管理页面
     *
     * @return 模板路径admin/admin_tag
     */
    @GetMapping
    public String tags() {
        return "admin/admin_tag";
    }
}
