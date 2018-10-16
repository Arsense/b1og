package com.halo.blog.web.controller.core;

/**
 * @author tangwei
 * @date 2018/10/9 17:02
 */
//如果你不想使用模板,请使用ResControllre 这个是不渲染模板的
public class BaseController {

    /**
     * 定义默认主题
     */
    public static String THEME = "anatole";


    /**
     * 根据主题名称渲染页面
     *
     * @param pageName pageName
     * @return 返回拼接好的模板路径
     */
    public String render(String pageName) {
        StringBuffer themePath = new StringBuffer("themes/");
        themePath.append(THEME);
        themePath.append("/");
        return themePath.append(pageName).toString();
    }

    /**
     * 渲染404页面
     *
     * @return redirect:/404
     */
    public String renderNotFound() {
        return "redirect:/404";
    }

}
