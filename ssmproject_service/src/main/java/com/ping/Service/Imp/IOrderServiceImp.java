package com.ping.Service.Imp;

import com.github.pagehelper.PageHelper;
import com.ping.Dao.IOrderDao;
import com.ping.Service.IOrderService;
import com.ping.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IOrderServiceImp implements IOrderService {
    @Autowired
    private IOrderDao iOrderDao;
    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return iOrderDao.findAll();
    }

    @Override
    public Orders findById(Integer orderSId) {
        return iOrderDao.findById(orderSId);
    }
}
