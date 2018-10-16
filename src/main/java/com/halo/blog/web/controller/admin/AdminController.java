package com.halo.blog.web.controller.admin;

import com.halo.blog.domain.User;
import com.halo.blog.enums.BaseConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * <pre>
 *     用户登录管理
 * </pre>
 *
 * @author tangwei
 * @date 2018/10/16 14:08
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    /**
     * 处理跳转到登录页的请求
     *
     * @param session session
     * @return 模板路径admin/admin_login
     */
    @GetMapping(value = "/login")
    public String login(HttpSession session) {
        User user = (User) session.getAttribute(BaseConstant.USER_SESSION_KEY);
        //如果session存在，跳转到后台首页
        if (null != user) {
            return "redirect:/admin";
        }
        return "admin/admin_login";
    }



}
