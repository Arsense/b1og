package com.halo.blog.web.controller.core;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.halo.blog.domain.Category;
import com.halo.blog.domain.Comment;
import com.halo.blog.domain.Post;
import com.halo.blog.domain.User;
import com.halo.blog.enums.BaseConstant;
import com.halo.blog.enums.PropertyEnum;
import com.halo.blog.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/9 16:57
 */

@Slf4j
@Controller
@RequestMapping(value = "/install")
public class InstallController {

    @Resource
    private UserService userService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private PostService postService;

    @Resource
    private CommentService commentService;

    @Resource
    private OptionsService optionsService;
    /**
     * 渲染安装页面
     *
     * @param model model
     * @return 模板路径
     */
    @GetMapping
    public String install(Model model){
        try {
            if (StringUtils.equals("true", BaseConstant.OPTIONS.get(PropertyEnum.IS_INSTALL.getProp()))) {
                model.addAttribute("isInstall", true);
            } else {
                model.addAttribute("isInstall", false);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "common/install";
    }

    /**
     * 执行安装
     *
     * @param blogTitle       博客标题
     * @param blogUrl         博客网址
     * @param userName        用户名
     * @param userDisplayName 用户名显示名
     * @param userEmail       用户邮箱
     * @param userPwd         用户密码
     * @param request         request
     * @return true：安装成功，false：安装失败
     */
    @PostMapping(value = "/do")
    @ResponseBody
    public boolean doInstall(
                             @RequestParam("blogTitle") String blogTitle,
                             @RequestParam("blogUrl") String blogUrl,
                             @RequestParam("userName") String userName,
                             @RequestParam("userDisplayName") String userDisplayName,
                             @RequestParam("userEmail") String userEmail,
                             @RequestParam("userPwd") String userPwd,
                             HttpServletRequest request){
        if (StringUtils.equals("true", BaseConstant.OPTIONS.get(PropertyEnum.IS_INSTALL.getProp()))) {
            return false;
        }
        //创建新的用户
        User user = new User();
        user.setUserName(userName);
        if (StringUtils.isBlank(userDisplayName)) {
            userDisplayName = userName;
        }
        user.setUserDisplayName(userDisplayName);
        user.setUserEmail(userEmail);
        //md5加密
        user.setUserPass(SecureUtil.md5(userPwd));
//        userService.saveByUser(user);

        //默认分类
        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        category.setCateName("未分类");
        category.setCateUrl("default");
        category.setCateDesc("未分类");
//        categoryService.saveByCategory(category);
        categories.add(category);

        //第一篇文章
        Post post = new Post();
        post.setPostTitle("Hello Halo!");
        post.setPostContentMd("# Hello Halo!\n" +
                "欢迎使用Halo进行创作，删除这篇文章后赶紧开始吧。");
        post.setPostContent("<h1 id=\"h1-hello-halo-\"><a name=\"Hello Halo!\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Hello Halo!</h1><p>欢迎使用Halo进行创作，删除这篇文章后赶紧开始吧。</p>\n");
        post.setPostSummary("欢迎使用Halo进行创作，删除这篇文章后赶紧开始吧。");
        post.setPostStatus(0);
        post.setPostDate(DateUtil.date());
        post.setPostUrl("hello-halo");
        post.setUser(user);
//        post.setCategories(categories);
        post.setAllowComment(1);
//        postService.saveByPost(post);

        //第一个评论
        Comment comment = new Comment();
//        comment.setPost(post);
        comment.setCommentAuthor("ruibaby");
        comment.setCommentAuthorEmail("i@ryanc.cc");
        comment.setCommentAuthorUrl("https://ryanc.cc");
        comment.setCommentAuthorIp("127.0.0.1");
        comment.setCommentDate(DateUtil.date());
        comment.setCommentContent("欢迎，欢迎！");
        comment.setCommentStatus(0);
        comment.setCommentAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36");
        comment.setIsAdmin(0);
//        commentService.saveByComment(comment);
        //开始设置系统属性

        optionsService.saveOption(PropertyEnum.IS_INSTALL.getProp(), "true");

        //保存博客标题和博客地址设置
        optionsService.saveOption(PropertyEnum.BLOG_TITLE.getProp(), blogTitle);
        optionsService.saveOption(PropertyEnum.BLOG_URL.getProp(), blogUrl);

        BaseConstant.OPTIONS.clear();
        BaseConstant.OPTIONS = optionsService.findAllOptions();



        return true;
    }



}
