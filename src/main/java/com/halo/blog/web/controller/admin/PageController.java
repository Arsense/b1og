package com.halo.blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/21 23:38
 */
@Controller
@RequestMapping(value = "/admin/page")
public class PageController {

    /**
     * 页面管理页面
     *
     * @param model model
     * @return 模板路径admin/admin_page
     */
    @GetMapping
    public String pages(Model model) {
        return "admin/admin_page";
    }

}
