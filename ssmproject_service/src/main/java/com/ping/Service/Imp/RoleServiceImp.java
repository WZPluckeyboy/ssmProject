package com.ping.Service.Imp;

import com.ping.Dao.IRoleDao;
import com.ping.Service.IRoleService;
import com.ping.domain.Permission;
import com.ping.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImp implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    @Override
    public List<Role> findAll() {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) {
        iRoleDao.save(role);
    }

    @Override
    public Role findById(Integer id) {
        return iRoleDao.findById(id);
    }

    @Override
    public List<Permission> findOtherPermissions(Integer id) {
        return iRoleDao.findOtherPermissions(id);
    }

    @Override
    public void addPermissionToRole(Integer id, Integer[] ids) {
        for (Integer i:ids) {
            iRoleDao.addPermissionToRole(id,i);
        }

    }
}
