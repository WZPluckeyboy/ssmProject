package com.ping.Service.Imp;

import com.ping.Dao.IPermissionDao;
import com.ping.Service.IPermissionService;
import com.ping.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImp implements IPermissionService {
    @Autowired
    private IPermissionDao iPermissionDao;
    @Override
    public List<Permission> findAll() {
        return iPermissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        iPermissionDao.save();
    }

    @Override
    public Permission findById(Integer id) {
        return iPermissionDao.findById( id);
    }
}
