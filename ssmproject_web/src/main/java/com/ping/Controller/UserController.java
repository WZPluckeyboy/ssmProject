package com.ping.Controller;

import com.ping.Service.IUserService;
import com.ping.domain.Role;
import com.ping.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("/findAll")
    public ModelAndView  findAll(){
     ModelAndView mv=new ModelAndView();
     List<Users> users=iUserService.findAll();
     mv.addObject("userList",users);
     mv.setViewName("user-list");
     return mv;
    }
    @RequestMapping("/save")
    public String save(Users users){

        iUserService.save(users);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public   ModelAndView findById(@RequestParam(name = "id",required = true) Integer id){
        ModelAndView mv=new ModelAndView();
         Users user= iUserService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return  mv;
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) Integer id){
        ModelAndView mv=new ModelAndView();
        Users user= iUserService.findById(id);
         List<Role> otherRoles=iUserService.findOtherRoles(id);
        mv.addObject("user",user);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return  mv;
    }
    @RequestMapping("/addRoleToUser")
   public String addRoleToUser(@RequestParam(name = "userId",required = true)Integer id,@RequestParam(name = "ids",required = true)Integer[] roleIds){
        iUserService.addRoleToUser(id,roleIds);
        return "redirect:findAll";
   }
}
