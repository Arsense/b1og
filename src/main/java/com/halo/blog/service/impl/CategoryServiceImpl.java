package com.halo.blog.service.impl;

import com.halo.blog.domain.Category;
import com.halo.blog.mapper.CategoryRepository;
import com.halo.blog.service.CategoryService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Category removeByCateId(Long cateId) {
        Optional<Category> category = this.findByCateId(cateId);
        categoryRepository.delete(category.get());
        return category.get();
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findByCateId(Long cateId) {
        return categoryRepository.findById(cateId);
    }
}
