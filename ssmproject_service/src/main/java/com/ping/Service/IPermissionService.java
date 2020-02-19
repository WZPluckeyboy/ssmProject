package com.ping.Service;

import com.ping.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll();

    void save(Permission permission);

    Permission findById(Integer id);
}
