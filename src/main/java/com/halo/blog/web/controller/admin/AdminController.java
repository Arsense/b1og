package com.halo.blog.web.controller.admin;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.halo.blog.domain.User;
import com.halo.blog.enums.BaseConstant;
import com.halo.blog.service.UserService;
import com.halo.blog.tool.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

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


    @Resource
    private UserService userService;

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

    /**
     * 验证登录信息
     *
     * @param loginName 登录名：邮箱／用户名
     * @param loginPwd  loginPwd 密码
     * @param session   session session
     * @return JsonResult JsonResult
     */
    @PostMapping(value = "/getLogin")
    @ResponseBody
    public JsonResult getLogin(@ModelAttribute("loginName") String loginName,
                               @ModelAttribute("loginPwd") String loginPwd,
                               HttpSession session) {
        //已注册账号，单用户，只有一个
        User admin = userService.findUser();
        //首先判断是否已经被禁用已经是否已经过了10分钟
        Date lastLoginTime = DateUtil.date();
        if (admin.getLoginLast() != null) {
            lastLoginTime = admin.getLoginLast();
        }
        //计算时间差 以分钟为单位
        Long between = DateUtil.between(lastLoginTime, DateUtil.date(), DateUnit.MINUTE);
        //如果不允许登录 而且登录时间差小于10分钟
        if (StringUtils.equals(admin.getLoginEnable(), "false") && (between < 10)) {
            return new JsonResult(0 , "已禁止登录，请10分钟后再试！");
        }
        //验证用户名和密码
        User user = null;
        // 两种登录方式 是用户名还是邮箱
        if (Validator.isEmail(loginName)) {
            user = userService.userLoginByEmail(loginName, SecureUtil.md5(loginPwd));
        } else {
            user = userService.userLoginByName(loginName, SecureUtil.md5(loginPwd));
        }
        userService.updateUserLoginLast(DateUtil.date());
//判断User对象是否相等
        if (ObjectUtil.equal(admin, user)) {
            session.setAttribute(BaseConstant.USER_SESSION_KEY, admin);
            //重置用户的登录状态为正常
            userService.updateUserNormal();
//            logsService.saveByLogs(new Logs(LogsRecord.LOGIN, LogsRecord.LOGIN_SUCCESS, ServletUtil.getClientIP(request), DateUtil.date()));
            log.info("用户[{}]登录成功。", admin.getUserDisplayName());
            return new JsonResult(1, "登陆成功");

        } else {
            //更新失败次数
            Integer errorCount = userService.updateUserLoginError();

            //超过五次禁用账户
            if (errorCount >= 5) {
                userService.updateUserLoginEnable("false");
            }
            Object[] args = {(5 - errorCount)};
            return new JsonResult(0, "登陆失败",args);
        }

        return null;


    }


}
