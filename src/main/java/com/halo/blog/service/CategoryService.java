package com.halo.blog.service;

import com.halo.blog.domain.Category;

import java.util.List;
import java.util.Optional;

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

    /**
     * 根据编号删除分类目录
     *
     * @param cateId 分类目录编号
     * @return category
     */
    Category removeByCateId(Long cateId);

    /**
     * 获取所有分类目录
     *
     * @return 返回List集合
     */
    List<Category> findAllCategories();
    /**
     * 根据编号查询单个分类
     *
     * @param cateId 分类编号
     * @return 返回category实体
     */
    Optional<Category> findByCateId(Long cateId);





}
