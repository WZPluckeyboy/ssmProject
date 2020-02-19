package com.ping.Dao;

import com.ping.domain.Role;
import com.ping.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IuserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,
                 many = @Many(select = "com.ping.Dao.IRoleDao.findRoleByUserId"))
    })
    Users findByUsername(String username);
    @Select("select * from users")
    List<Users> findAll();
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(Users users);
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,
                    many = @Many(select = "com.ping.Dao.IRoleDao.findRoleByUserId"))
    })
    Users findById(Integer id);
    @Select("select * from role where id not in (select roleId from users_role where usersId=#{id})")
    List<Role> findOtherRoles(Integer id);
    @Insert("insert into users_role(userId,roleId) values(#{id},#{roleId})")
    void addRoleToUser(@Param("id") Integer id, @Param("roleId") Integer roleId);
}
