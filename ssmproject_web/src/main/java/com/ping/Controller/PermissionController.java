package com.ping.Controller;

import com.ping.Service.IPermissionService;
import com.ping.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService ipermissionService;
    @RequestMapping("/findAll")
  public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Permission> permissions=ipermissionService.findAll();
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-list");
        return mv;
  }
    @RequestMapping("/save")
    public String save(Permission permission){

        ipermissionService.save(permission);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public   ModelAndView findById(@RequestParam(name = "id",required = true) Integer id){
        ModelAndView mv=new ModelAndView();
        Permission permission= ipermissionService.findById(id);
        mv.addObject("permission",permission);
        mv.setViewName("permission-show");
        return  mv;
    }
}
