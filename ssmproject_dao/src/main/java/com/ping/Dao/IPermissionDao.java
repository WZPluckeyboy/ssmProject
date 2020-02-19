package com.ping.Dao;

import com.ping.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(Integer id);
    @Select("select * from permission")
    List<Permission> findAll();
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save();
    @Select("select * from permission where id=#{id}")
    Permission findById(Integer id);
}
