package com.halo.blog.service;

import com.halo.blog.domain.Options;

import java.util.Map;

/**
 * @author tangwei
 * @date 2018/10/14 18:47
 */
public interface OptionsService {
    /**
     * 保存单个设置选项
     *
     * @param key   key
     * @param value value
     */
    void saveOption(String key, String value);

    /**
     * 获取所有设置选项
     *
     * @return Map
     */
    Map<String, String> findAllOptions();


    /**
     * 移除设置选项
     *
     * @param options options
     */
    void removeOption(Options options);
    void saveOptions(Map<String, String> options);
}
