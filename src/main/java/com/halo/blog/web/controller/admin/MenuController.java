package com.halo.blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tangwei
 * @date 2018/10/21 23:48
 */
@Controller
@RequestMapping(value = "/admin/menus")
public class MenuController {

    /**
     * 渲染菜单设置页面
     *
     * @return 模板路径/admin/admin_menu
     */
    @GetMapping
    public String menus() {
        return "/admin/admin_menu";
    }
}
