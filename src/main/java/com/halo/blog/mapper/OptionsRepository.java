package com.halo.blog.mapper;

import com.halo.blog.domain.Options;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tangwei
 * @date 2018/10/14 18:48
 */
public interface OptionsRepository extends JpaRepository<Options,Long> {

    /**
     * 根据key查询单个option
     *
     * @param key key
     * @return Options
     */
    Options findOptionsByOptionName(String key);

}
