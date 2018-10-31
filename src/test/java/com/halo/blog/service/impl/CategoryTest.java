package com.halo.blog.service.impl;

import com.halo.blog.BaseConfigTest;
import com.halo.blog.domain.Category;
import com.halo.blog.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/31 14:35
 */
public class CategoryTest extends BaseConfigTest {


    @Autowired
    private CategoryService categoryService;

    /**
     * 添加测试OK
     */
    @Test
    public void testAdd(){
        Category category = new Category();
        category.setCateDesc("描述");
        category.setCateName("测试");
        category.setCateUrl("/test");
        categoryService.saveByCategory(category);
        List<Category> categories =  categoryService.findAllCategories();

    }

    /**
     * 删除测试OK
     */
    @Test
    public void testDetele(){
        Long id = 162L;
        categoryService.removeByCateId(id);
        List<Category> categories =  categoryService.findAllCategories();
    }


}
