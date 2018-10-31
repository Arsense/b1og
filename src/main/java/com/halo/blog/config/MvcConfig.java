package com.halo.blog.config;

import com.halo.blog.web.intercaptor.InstallInterceptor;
import com.halo.blog.web.intercaptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import java.util.Locale;

/**
 *
 *//**
 * <pre>
 *     拦截器，资源路径配置
 * </pre>
 *
 @author tangwei
  * @date 2018/10/9 17:58
 */
@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.halo.blog.web.controller")
@PropertySource(value = "classpath:application.yml", ignoreResourceNotFound = true, encoding = "UTF-8")
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    private InstallInterceptor installInterceptor;

    @Resource
    private LoginInterceptor loginInterceptor;


    /**
     * 注册拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(installInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/install")
                .excludePathPatterns("/install/do")
                .excludePathPatterns("/static/**");

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/admin/**")
                .addPathPatterns("/backup/**")  //备份页面拦截
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/getLogin") //登录的几个页面不拦截
                .excludePathPatterns("/static/**");

    }

    /**
     * 配置静态资源路径
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //不加的话无法加载静态资源
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/themes/");
//                .addResourceLocations("classpath:/robots.txt");
//        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("file:///" + System.getProperties().getProperty("user.home") + "/halo/upload/");
        registry.addResourceHandler("/favicon.ico")
                .addResourceLocations("classpath:/static/images/favicon.ico");
//        registry.addResourceHandler("/backup/**")
//                .addResourceLocations("file:///" + System.getProperties().getProperty("user.home") + "/halo/backup/");
    }

    /**
     * 国际化配置设置语言区域
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }
}
