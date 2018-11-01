package com.halo.blog.web.controller.admin;

import com.halo.blog.domain.BackFileVo;
import com.halo.blog.service.impl.BackUpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/21 23:46
 */
@Controller
@RequestMapping(value = "/admin/backup")
public class BackupController {


    @Resource
    private BackUpService backUpService;
    /**
     * 渲染备份页面
     *
     * 选择备份类型
     *
     * @param model model
     * @return 模板路径admin/admin_backup
     */
    @GetMapping
    public String backup(@RequestParam(value = "type", defaultValue = "resources") String type, Model model) {
        List<BackFileVo> backups =  backUpService.getBackupFile(type);;

        return "admin/admin_backup";
    }



}
