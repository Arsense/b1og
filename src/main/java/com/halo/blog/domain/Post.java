package com.halo.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *     文章／页面
 * </pre>
 *
 * @author tangwei
 * @date 2018/10/12 10:45
 */
@Data
@Entity
@Table(name = "post")
public class Post implements Serializable {
    /**
     * 文章编号
     */
    @Id
    @GeneratedValue
    private Long postId;


    /**
     * 发表用户 多对一
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;


    /**
     * 文章标题
     */
    private String postTitle;


    /**
     * 文章类型
     * post  文章
     * page  页面
     */
    private String postType = "post";

    /**
     * 文章内容 Markdown格式
     */
    @Lob
    private String postContentMd;

    /**
     * 文章内容 html格式
     */
    @Lob
    private String postContent;

    /**
     * 文章路径
     */
    @Column(unique = true)
    private String postUrl;

    /**
     * 文章摘要
     */
    private String postSummary;
//    /**
//     * 文章所属分类
//     */
//    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
//    @JoinTable(name = "halo_posts_categories",
//            joinColumns = {@JoinColumn(name = "post_id", nullable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "cate_id", nullable = false)})
//    private List<Category> categories = new ArrayList<>();


//    /**
//     * 文章所属标签
//     */
//    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
//    @JoinTable(name = "halo_posts_tags",
//            joinColumns = {@JoinColumn(name = "post_id", nullable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false)})
//    private List<Tag> tags = new ArrayList<>();


    /**
     * 文章的评论
     */
    @OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();


    /**
     * 缩略图
     */
    private String postThumbnail;

    /**
     * 发表日期
     */
    private Date postDate;

    /**
     * 最后一次更新时间
     */
    private Date postUpdate;

    /**
     * 0 已发布
     * 1 草稿
     * 2 回收站
     */
    private Integer postStatus = 0;

    /**
     * 文章访问量
     */
    private Long postViews = 0L;

    /**
     * 是否允许评论
     */
    private Integer allowComment = 0;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public Date getPostDate() {
        return postDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public Date getPostUpdate() {
        return postUpdate;
    }


    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostContentMd() {
        return postContentMd;
    }

    public void setPostContentMd(String postContentMd) {
        this.postContentMd = postContentMd;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getPostSummary() {
        return postSummary;
    }

    public void setPostSummary(String postSummary) {
        this.postSummary = postSummary;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getPostThumbnail() {
        return postThumbnail;
    }

    public void setPostThumbnail(String postThumbnail) {
        this.postThumbnail = postThumbnail;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setPostUpdate(Date postUpdate) {
        this.postUpdate = postUpdate;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public Long getPostViews() {
        return postViews;
    }

    public void setPostViews(Long postViews) {
        this.postViews = postViews;
    }

    public Integer getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Integer allowComment) {
        this.allowComment = allowComment;
    }
}
