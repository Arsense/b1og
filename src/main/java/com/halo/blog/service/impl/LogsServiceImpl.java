package com.halo.blog.service.impl;

import com.halo.blog.domain.Logs;
import com.halo.blog.mapper.LogsRepository;
import com.halo.blog.service.LogsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/17 10:38
 */
@Service
public class LogsServiceImpl implements LogsService{

    @Resource
    private LogsRepository logsRepository;


    @Override
    public List<Logs> findLogsLatest() {
        return logsRepository.findTopFive();

    }
}
