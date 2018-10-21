package com.halo.blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tangwei
 * @date 2018/10/21 23:47
 */
@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {



    /**
     * 查询所有分类并渲染category页面
     *
     * @return 模板路径admin/admin_category
     */
    @GetMapping
    public String categories() {
        return "admin/admin_category";
    }
}
