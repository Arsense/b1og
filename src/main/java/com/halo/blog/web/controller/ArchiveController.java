package com.halo.blog.web.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.PageUtil;
import com.halo.blog.domain.Comment;
import com.halo.blog.domain.ListPage;
import com.halo.blog.domain.Post;
import com.halo.blog.domain.Tag;
import com.halo.blog.enums.BaseConstant;
import com.halo.blog.enums.PropertyEnum;
import com.halo.blog.service.CommentService;
import com.halo.blog.service.PostService;
import com.halo.blog.util.CommentUtil;
import com.halo.blog.web.controller.core.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *     前台文章归档控制器
 * </pre>
 * @author tangwei
 * @date 2018/10/18 13:38
 */
@Controller
@RequestMapping(value = "/archives")
public class ArchiveController extends BaseController {

    @Resource
    private PostService postService;

    @Resource
    private CommentService commentService;

    /**
     * 文章归档
     *
     * @param model model
     * @return 模板路径
     */
    @GetMapping
    public String archives(Model model) {
        return this.archives(model, 1);
    }

    /**
     * 文章归档，根据年月
     *
     * @param model model
     * @param year  year 年份
     * @param month month 月份
     * @return 模板路径/themes/{theme}/archives
     */
    @GetMapping(value = "{year}/{month}")
    public String archives(Model model,
                           @PathVariable(value = "year") String year,
                           @PathVariable(value = "month") String month) {


        return this.render("archives");
    }

    /**
     * 文章归档分页
     *
     * @param model model
     * @param page  page 当前页码
     * @return 模板路径/themes/{theme}/archives
     */
    @GetMapping(value = "page/{page}")
    public String archives(Model model,
                           @PathVariable(value = "page") Integer page) {

        //所有文章数据，分页，material主题适用
        Sort sort = new Sort(Sort.Direction.DESC, "postDate");
        Pageable pageable = PageRequest.of(page - 1, 5, sort);
        Page<Post> posts = postService.findPostByStatus(0, "post", pageable);
        if (null == posts) {
            return this.renderNotFound();
        }
        model.addAttribute("is_archives",true);
        model.addAttribute("posts", posts);
        return this.render("archives");
    }

    /**
     * 渲染文章详情
     *
     * @param postUrl 文章路径名
     * @param model   model
     * @return 模板路径/themes/{theme}/post
     */
    @GetMapping(value = "{postUrl}")
    public String getPost(@PathVariable String postUrl,
                          @RequestParam(value = "cp",defaultValue = "1") Integer cp, Model model){
        Post post = postService.findByPostUrl(postUrl, "post");
        if (null == post || !post.getPostStatus().equals(0)) {
            return this.renderNotFound();
        }
        //获得当前文章的发布日期
        Date postDate = post.getPostDate();
        //查询当前文章日期之前的所有文章
        List<Post> beforePosts = postService.findByPostDateBefore(postDate);
        //查询当前文章日期之后的所有文章
        List<Post> afterPosts = postService.findByPostDateAfter(postDate);

        if (null != beforePosts && beforePosts.size() > 0) {
            model.addAttribute("beforePost", beforePosts.get(beforePosts.size() - 1));
        }
        if (null != afterPosts && afterPosts.size() > 0) {
            model.addAttribute("afterPost", afterPosts.get(afterPosts.size() - 1));
        }

        List<Comment> comments = null;

        //查询评论是否需要审核
        if (StringUtils.equals(BaseConstant.OPTIONS.get(PropertyEnum.COMMENT_NEED_CHECK.getProp()), "true") || BaseConstant.OPTIONS.get(PropertyEnum.COMMENT_NEED_CHECK.getProp()) == null) {
            comments = commentService.findCommentsByPostAndCommentStatus(post,0);
        } else {
            comments = commentService.findCommentsByPostAndCommentStatusNot(post,2);
        }
        //获取文章的标签用作keywords
        List<Tag> tags = post.getTags();
        List<String> tagWords = new ArrayList<>();
        if (tags != null) {
            for (Tag tag : tags) {
                tagWords.add(tag.getTagName());
            }
        }
        //默认显示10条
        Integer size = 10;
        //获取每页评论条数
        if (!StringUtils.isBlank(BaseConstant.OPTIONS.get(PropertyEnum.INDEX_COMMENTS.getProp()))) {
            size = Integer.parseInt(BaseConstant.OPTIONS.get(PropertyEnum.INDEX_COMMENTS.getProp()));
        }
        //评论分页
        ListPage<Comment> commentsPage = new ListPage<Comment>(CommentUtil.getComments(comments),cp, size);

        int[] rainbow = PageUtil.rainbow(cp, commentsPage.getTotalPage(), 3);

        model.addAttribute("is_post",true);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentsPage);
        model.addAttribute("commentsCount", comments.size());
        model.addAttribute("rainbow", rainbow);
        model.addAttribute("tagWords", CollUtil.join(tagWords, ","));
        postService.updatePostView(post); //修改文章阅读量

        return this.render("post");
    }

}
