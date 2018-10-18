package com.halo.blog.service;

import com.halo.blog.domain.Menu;

import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/18 14:57
 */
public interface MenuService {

    /**
     * 查询所有菜单
     *
     * @return List
     */
    List<Menu> findAllMenus();
}
