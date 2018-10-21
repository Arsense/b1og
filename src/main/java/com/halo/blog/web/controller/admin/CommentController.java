package com.halo.blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tangwei
 * @date 2018/10/21 23:48
 */
@Controller
@RequestMapping(value = "/admin/comments")
public class CommentController {

    /**
     * 渲染评论管理页面
     *
     * @param model  model
     * @param status status 评论状态
     * @param page   page 当前页码
     * @param size   size 每页显示条数
     * @return 模板路径admin/admin_comment
     */
    @GetMapping
    public String comments(Model model,
                           @RequestParam(value = "status", defaultValue = "0") Integer status,
                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                           @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return "admin/admin_comment";

    }
}
