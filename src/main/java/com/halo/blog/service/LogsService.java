package com.halo.blog.service;

import com.halo.blog.domain.Logs;
import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/17 10:38
 */
public interface LogsService {

    /**
     * 查询最新的五条日志
     *
     * @return List
     */
    List<Logs> findLogsLatest();
}
