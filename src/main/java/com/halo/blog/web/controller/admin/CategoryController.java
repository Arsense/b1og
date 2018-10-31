package com.halo.blog.web.controller.admin;

import com.halo.blog.domain.Category;
import com.halo.blog.service.CategoryService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author tangwei
 * @date 2018/10/21 23:47
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有分类并渲染category页面
     *
     * @return 模板路径admin/admin_category
     */
    @GetMapping
    public String categories() {
        return "admin/admin_category";
    }

    /**
     * 新增/修改分类目录
     *
     * @param category category对象
     * @return 重定向到/admin/category
     */
    @PostMapping(value = "/save")
    public String saveCategory(@ModelAttribute Category category) {

        try {
            categoryService.saveByCategory(category);
        } catch (Exception e) {
            log.error("修改分类失败：{}", e.getMessage());
        }
        return "redirect:/admin/category";
    }

    /**
     * 处理删除分类目录的请求
     *
     * @param cateId cateId
     * @return 重定向到/admin/category
     */
    @GetMapping(value = "/remove")
    public String removeCategory(@RequestParam("cateId") Long cateId) {
        try {
            categoryService.removeByCateId(cateId);
        } catch (Exception e) {
            log.error("删除分类失败：{}", e.getMessage());
        }
        return "redirect:/admin/category";
    }


    /**
     * 跳转到修改页面
     *
     * @param cateId cateId
     * @param model  model
     * @return 模板路径admin/admin_category
     */
    @GetMapping(value = "/edit")
    public String toEditCategory(Model model, @RequestParam("cateId") Long cateId) {
        Optional<Category> category = categoryService.findByCateId(cateId);
        model.addAttribute("updateCategory", category.get());
        return "admin/admin_category";
    }

}
