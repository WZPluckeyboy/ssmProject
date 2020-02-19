package com.ping.Dao;

import com.ping.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITraveller {
    @Select("select * from traveller where id " +
            "in (select travellerId from order_traveller  where orderId=#{ordersId})")
    public List<Traveller> findByOrderId(Integer ordersId) ;
}
