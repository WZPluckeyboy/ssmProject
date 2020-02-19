package com.ping.Service.Imp;

import com.ping.Dao.ISysLogDao;
import com.ping.Service.ISysLogService;
import com.ping.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogImp implements ISysLogService {
    @Autowired
    private ISysLogDao iSysLogDao;
    @Override
    public void save(SysLog sysLog) {
      iSysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return iSysLogDao.findAll();
    }
}
