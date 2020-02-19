package com.ping.Dao;

import com.ping.domain.Member;
import com.ping.domain.Orders;
import com.ping.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.ping.Dao.IProductDao.findById")),
    })
    List<Orders> findAll();
    @Select("select * from orders where id=#{orderSId}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.ping.Dao.IProductDao.findById")),
            @Result(property = "member",column = "memberid",javaType = Member.class,one = @One(select ="com.ping.Dao.IMemberDao.findById")),
            @Result(property ="travellers" ,column = "id",javaType = List.class,many = @Many(select ="com.ping.Dao.ITraveller.findByOrderId" ))
    })
    Orders findById(Integer orderSId);
}
