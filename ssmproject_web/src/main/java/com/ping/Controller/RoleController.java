package com.ping.Controller;

import com.ping.Service.IRoleService;
import com.ping.domain.Permission;
import com.ping.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Role> roles =iRoleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/save")
    public String save(Role role){

        iRoleService.save(role);
        return "redirect:findAll";
    }
    @RequestMapping("/findRoleByIdAndAllPermission")
    public  ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) Integer id){
        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = iRoleService.findById(id);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = iRoleService.findOtherPermissions(id);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) Integer id, @RequestParam(name = "ids", required = true) Integer[] ids)  {
        iRoleService.addPermissionToRole(id, ids);
        return "redirect:findAll";
    }
}
