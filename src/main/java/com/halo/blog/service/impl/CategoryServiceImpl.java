package com.halo.blog.service.impl;

import com.halo.blog.domain.Category;
import com.halo.blog.mapper.CategoryRepository;
import com.halo.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tangwei
 * @date 2018/10/12 10:42
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public Category saveByCategory(Category category) {
        return categoryRepository.save(category);
    }
}
