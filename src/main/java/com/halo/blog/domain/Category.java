package com.halo.blog.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author tangwei
 * @date 2018/10/10 14:35
 */
@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {
    /**
     * 分类编号
     */
    @Id
    @GeneratedValue
    private Long cateId;

    /**
     * 分类名称
     */
    @NotBlank(message = "分类名称不能为空")
    private String cateName;

    /**
     * 分类路径
     */
    @NotBlank(message = "分类路径不能为空")
    private String cateUrl;

    /**
     * 分类描述
     */
    private String cateDesc;

//    @ManyToMany(mappedBy = "categories")
//    @JsonIgnore
//    private List<Post> posts = new ArrayList<>();


    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateUrl() {
        return cateUrl;
    }

    public void setCateUrl(String cateUrl) {
        this.cateUrl = cateUrl;
    }

    public String getCateDesc() {
        return cateDesc;
    }

    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc;
    }
}
