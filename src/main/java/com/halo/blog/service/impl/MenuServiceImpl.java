package com.halo.blog.service.impl;

import com.halo.blog.domain.Menu;
import com.halo.blog.mapper.MenuRepository;
import com.halo.blog.service.MenuService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/18 14:57
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuRepository menuRepository;

    @Override
    public List<Menu> findAllMenus() {
        return menuRepository.findAll();

    }
}
