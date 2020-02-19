package com.ping.Dao;
import com.ping.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface IProductDao {
    @Select("select * from product")
    List<Product> findAll() ;
     @Insert("insert into product (id,productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus ) values" +
             " (#{id},#{productNum},#{productName},#{cityName},#{DepartureTime},#{productPrice},#{productDesc},#{productStatus })")
    void save(Product product);
    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(Integer id) ;
}
