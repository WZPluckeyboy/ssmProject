package com.ping.Dao;

import com.ping.domain.Permission;
import com.ping.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where usersId=#{id})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ping.Dao.IPermissionDao.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(Integer id);
    @Select("select * from role")
    List<Role> findAll();
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ping.Dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(Integer id);
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findOtherPermissions(Integer id);
    @Insert("insert into role_permission(roleId,permissionId) values(#{id},#{ids})")
    void addPermissionToRole(@Param("id")Integer id,@Param("ids") Integer ids);
}
