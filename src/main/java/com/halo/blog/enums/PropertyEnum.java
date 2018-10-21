package com.halo.blog.enums;

/**
 * @author tangwei
 * @date 2018/10/9 20:13
 */
public enum PropertyEnum {

    /**
     * 是否已经安装
     */
    IS_INSTALL("is_install"),
    /**
     * 首页文章条数
     */
    INDEX_POSTS("index_posts"),
    /**
     * 博客标题
     */
    BLOG_TITLE("blog_title"),
    /**
     * 新评论是否需要审核
     */
    COMMENT_NEED_CHECK("comment_need_check"),
    /**
     * 每页评论条数
     */
    INDEX_COMMENTS("index_comments"),
    /**
     * 博客地址
     */
    BLOG_URL("blog_url");


    private String prop;

    PropertyEnum(String prop) {
        this.prop = prop;
    }

    public String getProp() {
        return prop;
    }
}
