package com.halo.blog.web.controller.admin;

import com.halo.blog.enums.BaseConstant;
import com.halo.blog.service.OptionsService;
import com.halo.blog.tool.JsonResult;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author tangwei
 * @date 2018/10/21 23:49
 */

@Slf4j
@Controller
@RequestMapping("/admin/option")
public class OptionController {


    @Autowired
    private OptionsService optionsService;
    @Autowired
    private Configuration configuration;


    /**
     * 请求跳转到option页面并完成渲染
     *
     * @return 模板路径admin/admin_option
     */
    @GetMapping
    public String options() {
        return "admin/admin_option";
    }

    /**
     * 保存设置选项
     *
     * @param options options
     * @return JsonResult
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public JsonResult saveOptions(@RequestParam Map<String, String> options) throws TemplateModelException {
        optionsService.saveOptions(options);
        configuration.setSharedVariable("options", optionsService.findAllOptions());
        BaseConstant.OPTIONS.clear();
        BaseConstant.OPTIONS = optionsService.findAllOptions();
        log.info("所保存的设置选项列表：" + options);
        return new JsonResult(1, "保存成功");



    }


}
