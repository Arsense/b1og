package com.halo.blog.web.controller;

import cn.hutool.core.util.PageUtil;
import com.halo.blog.domain.Post;
import com.halo.blog.enums.BaseConstant;
import com.halo.blog.enums.PropertyEnum;
import com.halo.blog.service.PostService;
import com.halo.blog.web.controller.core.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * @author tangwei
 * @date 2018/10/9 17:10
 */

@Controller
@RequestMapping(value = {"/", "index"})
public class IndexController extends BaseController {

    @Resource
    private PostService postService;

    /**
     * 请求首页
     *
     * @param model model
     * @return 模板路径
     */
    @GetMapping
    public String index(Model model) {
        //调用方法渲染首页
        return this.index(model, 1);
    }

    @GetMapping(value = "page/{page}")
    public String index(Model model,
                        @PathVariable(value = "page") Integer page){
        Sort sort = new Sort(Sort.Direction.DESC, "postDate");
        //默认显示10条
        Integer size = 10;
        //尝试加载设置选项，用于设置显示条数
        String pageNumber = BaseConstant.OPTIONS.get(PropertyEnum.INDEX_POSTS.getProp());
        if (!StringUtils.isBlank(pageNumber)) {
            size = Integer.parseInt(pageNumber);
        }
        //所有文章数据，分页
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<Post> posts = postService.findPostByStatus(pageable);
        if (null == posts) {
            return this.renderNotFound();
        }
        int[] rainbow = PageUtil.rainbow(page, posts.getTotalPages(), 3);
        model.addAttribute("is_index",true);
        model.addAttribute("posts", posts);
        model.addAttribute("rainbow", rainbow);
        return this.render("index");
    }
}
