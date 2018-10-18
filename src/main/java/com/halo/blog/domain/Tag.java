package com.halo.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     文章标签
 * </pre>
 * @author tangwei
 * @date 2018/10/12 10:52
 */
@Data
@Entity
@Table(name = "halo_tag")
public class Tag implements Serializable {
    /**
     * 标签编号
     */
    @Id
    @GeneratedValue
    private Long tagId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 标签路径
     */
    private String tagUrl;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();


    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagUrl() {
        return tagUrl;
    }

    public void setTagUrl(String tagUrl) {
        this.tagUrl = tagUrl;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
