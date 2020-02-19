package com.ping.Service;

import com.ping.domain.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAll(int page,int size);

    Orders findById(Integer orderSId);
}
