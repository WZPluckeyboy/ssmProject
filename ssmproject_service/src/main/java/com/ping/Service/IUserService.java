package com.ping.Service;
import com.ping.domain.Role;
import com.ping.domain.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<Users> findAll();

    void save(Users users);

    Users findById(Integer id);

    List<Role> findOtherRoles(Integer id);

    void addRoleToUser(Integer id, Integer[] roleIds);
}
