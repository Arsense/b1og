package com.halo.blog.config;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Map;

/**
 * @author tangwei
 * @date 2018/10/18 11:14
 */
@Component
public class CommonTagDirective  implements TemplateDirectiveModel {
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

    }
}
