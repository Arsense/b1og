package com.halo.blog.config;

import com.halo.blog.enums.PostTypeEnum;
import com.halo.blog.service.PostService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * <pre>
 *     FreeMarker自定义标签
 * </pre>
 *
 * @author tangwei
 * @date 2018/10/18 11:03
 */
@Component
public class ArticleTagDirective implements TemplateDirectiveModel {

    private static final String METHOD_KEY = "method";

    @Resource
    private PostService postService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if (map.containsKey(METHOD_KEY)){
            String method = map.get(METHOD_KEY).toString();
            switch (method) {
                case "postsCount":
                environment.setVariable("postsCount", builder.build().wrap(postService.findPostByStatus(0, PostTypeEnum.POST_TYPE_POST.getDesc()).size()));
                    break;
                default:
                    break;

            }

            }
        templateDirectiveBody.render(environment.getOut());

    }
}
