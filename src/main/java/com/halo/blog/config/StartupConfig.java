package com.halo.blog.config;

import com.halo.blog.enums.BaseConstant;
import com.halo.blog.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * <pre>
 *     应用启动的时候所执行的方法
 * </pre>
 * @author tangwei
 * @date 2018/10/9 17:55
 */

@Configuration
public class StartupConfig implements ApplicationListener<ApplicationStartedEvent> {


    //主题
    @Resource
    private OptionsService optionsService;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        this.loadOptions();

    }

    //这里读取配置
    /**
     * 加载设置选项
     */
    private void loadOptions() {
        Map<String, String> options = optionsService.findAllOptions();
        if (options != null && !options.isEmpty()) {
            BaseConstant.OPTIONS = options;
        }
    }

}
