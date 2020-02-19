package com.ping.Service;

import com.ping.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    void save(SysLog sysLog);
    List<SysLog> findAll();

}
