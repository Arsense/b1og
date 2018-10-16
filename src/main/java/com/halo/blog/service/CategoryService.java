package com.halo.blog.service;

import com.halo.blog.domain.Category;

/**
 * @author tangwei
 * @date 2018/10/12 10:42
 */

public interface CategoryService {

    /**
     * 新增/修改分类目录
     *
     * @param category 分类目录
     * @return 如果插入成功，返回分类目录对象
     */
    Category saveByCategory(Category category);

}
