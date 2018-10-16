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
    INDEX_POSTS("index_posts");

    private String prop;

    PropertyEnum(String prop) {
        this.prop = prop;
    }

    public String getProp() {
        return prop;
    }
}
