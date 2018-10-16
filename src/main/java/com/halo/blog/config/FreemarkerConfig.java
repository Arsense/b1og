package com.halo.blog.config;

import com.halo.blog.service.OptionsService;
import com.halo.blog.service.UserService;
import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author tangwei
 * @date 2018/10/16 10:49
 */
@Slf4j
@Configuration
public class FreemarkerConfig {

    //创建一个freemarker.template.Configuration实例，它是存储 FreeMarker 应用级设置的核心部分
    @Resource
    private freemarker.template.Configuration configuration;

    @Resource
    private OptionsService optionsService;

    @Resource
    private UserService userService;

    /**
     * 前端页面配置
     */
    @PostConstruct
    public void setSharedVariable() {
        try{
            configuration.setSharedVariable("options", optionsService.findAllOptions());
            configuration.setSharedVariable("user", userService.findUser());

        }catch (TemplateModelException e){
            log.error("自定义标签加载失败：{}", e.getMessage());

        }

    }

}
