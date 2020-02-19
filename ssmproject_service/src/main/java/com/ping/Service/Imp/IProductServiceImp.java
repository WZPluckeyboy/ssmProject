package com.ping.Service.Imp;

import com.ping.Dao.IProductDao;
import com.ping.Service.IProductService;
import com.ping.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IProductServiceImp implements IProductService {
    @Autowired
    private IProductDao iProductDao;
    @Override
    public List<Product> findAll()  {
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) {
        iProductDao.save(product);
    }
}
