package com.halo.blog.web.controller.admin;

import com.halo.blog.domain.Link;
import com.halo.blog.domain.Post;
import com.halo.blog.enums.PostTypeEnum;
import com.halo.blog.service.LinkService;
import com.halo.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author tangwei
 * @date 2018/10/21 23:38
 */
@Controller
@RequestMapping(value = "/admin/page")
public class PageController {

    @Resource
    private PostService postService;

    @Resource
    private LinkService linkService;

    /**
     * 页面管理页面
     *
     * @param model model
     * @return 模板路径admin/admin_page
     */
    @GetMapping
    public String pages(Model model) {
        List<Post> posts = postService.findAllPosts(PostTypeEnum.POST_TYPE_PAGE.getDesc());
        model.addAttribute("pages", posts);
        return "admin/admin_page";
    }

    /**
     * 获取友情链接列表并渲染页面
     *
     * @return 模板路径admin/admin_page_link
     */
    @GetMapping(value = "/links")
    public String links() {
        return "admin/admin_page_link";
    }


    /**
     * 跳转到修改页面
     *
     * @param model  model
     * @param linkId linkId 友情链接编号
     * @return String 模板路径admin/admin_page_link
     */
    @GetMapping(value = "/links/edit")
    public String toEditLink(Model model, @RequestParam("linkId") Long linkId) {
        Optional<Link> link = linkService.findByLinkId(linkId);
        model.addAttribute("updateLink", link.get());
        return "admin/admin_page_link";
    }


}
