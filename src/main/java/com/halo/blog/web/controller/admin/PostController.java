package com.halo.blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tangwei
 * @date 2018/10/21 23:28
 */
@Controller
@RequestMapping(value = "/admin/posts")
public class PostController {


    /**
     * 处理后台获取文章列表的请求
     *
     * @param model model
     * @param page  当前页码
     * @param size  每页显示的条数
     * @return 模板路径admin/admin_post
     */
    @GetMapping
    public String posts(Model model,
                        @RequestParam(value = "status", defaultValue = "0") Integer status,
                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return "admin/admin_post";
    }
}
