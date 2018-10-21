package com.halo.blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tangwei
 * @date 2018/10/21 23:46
 */
@Controller
@RequestMapping(value = "/admin/backup")
public class BackupController {
    /**
     * 渲染备份页面
     *
     * @param model model
     * @return 模板路径admin/admin_backup
     */
    @GetMapping
    public String backup(@RequestParam(value = "type", defaultValue = "resources") String type, Model model) {
        return "admin/admin_backup";
    }



}
