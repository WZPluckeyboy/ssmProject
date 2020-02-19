package com.ping.Service;

import com.ping.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll() ;

    void save(Product product);
}
