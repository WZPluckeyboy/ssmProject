package com.ping.Controller;

import com.github.pagehelper.PageInfo;
import com.ping.Service.IOrderService;
import com.ping.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size)  {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = iOrderService.findAll(page, size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name ="id",required = true)Integer orderSId){
        ModelAndView mv = new ModelAndView();
        Orders orders= iOrderService.findById(orderSId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
