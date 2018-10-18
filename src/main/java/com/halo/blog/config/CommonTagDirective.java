package com.halo.blog.config;

import com.halo.blog.service.MenuService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * @author tangwei
 * @date 2018/10/18 11:14
 */
@Component
public class CommonTagDirective  implements TemplateDirectiveModel {

    private static final String METHOD_KEY = "method";


    @Resource
    protected MenuService menuService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if (map.containsKey(METHOD_KEY)) {
            String method = map.get(METHOD_KEY).toString();
            switch (method) {
                case "menus":
                    environment.setVariable("menus", builder.build().wrap(menuService.findAllMenus()));
                    break;
                default:
                    break;
            }
        }
        templateDirectiveBody.render(environment.getOut());

    }
}
