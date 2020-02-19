package com.ping.Service;

import com.ping.domain.Permission;
import com.ping.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() ;

    void save(Role role);

    Role findById(Integer id);

    List<Permission> findOtherPermissions(Integer id);

    void addPermissionToRole(Integer id, Integer[] ids);
}
