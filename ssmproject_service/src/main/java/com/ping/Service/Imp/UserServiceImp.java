package com.ping.Service.Imp;

import com.ping.Dao.IuserDao;
import com.ping.Service.IUserService;
import com.ping.domain.Role;
import com.ping.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImp implements IUserService {
    @Autowired
    private IuserDao iuserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Users users=  iuserDao.findByUsername(username);
     //User user=new User(users.getUsername(),"(noop)"+users.getPassword(),getAuthorities());
        User user = new User(users.getUsername(), users.getPassword(), users.getStatus() == 0 ? false : true, true, true, true, getAuthorities(users.getRoles()));
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role:roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }

        return list;
    }

    @Override
    public List<Users> findAll() {
        return iuserDao.findAll();
    }

    @Override
    public void save(Users users) {
        //密码加密
       users.setPassword( bCryptPasswordEncoder.encode(users.getPassword()));
        iuserDao.save(users);
    }

    @Override
    public Users findById(Integer id) {
        return iuserDao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(Integer id) {
        return iuserDao.findOtherRoles( id);
    }

    @Override
    public void addRoleToUser(Integer id, Integer[] roleIds) {
        for (Integer roleId:roleIds) {
            iuserDao.addRoleToUser( id, roleId);
        }
    }
}
