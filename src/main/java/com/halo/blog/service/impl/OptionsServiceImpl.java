package com.halo.blog.service.impl;

import com.halo.blog.domain.Options;
import com.halo.blog.mapper.OptionsRepository;
import com.halo.blog.service.OptionsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tangwei
 * @date 2018/10/14 18:47
 */
@Service
public class OptionsServiceImpl implements OptionsService {


    @Resource
    private OptionsRepository optionsRepository;


    /**
     * 批量保存设置
     *
     * @param options options
     */
    @Override
    public void saveOptions(Map<String, String> options) {
        if (null != options && !options.isEmpty()) {
            options.forEach((k, v) -> saveOption(k, v));
        }
    }

    @Override
    public void saveOption(String key, String value) {
        Options options = null;
        if (StringUtils.equals(value, "")) {
            options = new Options();
            options.setOptionName(key);
            this.removeOption(options);
        } else {
            if (StringUtils.isNotEmpty(key)) {
                //如果查询到有该设置选项则做更新操作，反之保存新的设置选项
                if (null == optionsRepository.findOptionsByOptionName(key)) {
                    options = new Options();
                    options.setOptionName(key);
                    options.setOptionValue(value);
                    optionsRepository.save(options);
                } else {
                    options = optionsRepository.findOptionsByOptionName(key);
                    options.setOptionValue(value);
                    optionsRepository.save(options);
                }
            }
        }
    }
    @Override
    public Map<String, String> findAllOptions() {
        Map<String, String> options = new HashMap<>();
        List<Options> optionsList = optionsRepository.findAll();
        optionsList.forEach(option -> options.put(option.getOptionName(), option.getOptionValue()));
        return options;
    }

    @Override
    public void removeOption(Options options) {
        optionsRepository.delete(options);
    }
}
