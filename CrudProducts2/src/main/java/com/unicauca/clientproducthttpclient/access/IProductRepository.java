package com.unicauca.clientproducthttpclient.access;

import com.unicauca.clientproducthttpclient.domain.entities.Product;
import java.util.List;

public interface IProductRepository {

    public List<Product> findAll();

    Product findById(long id);

    public void create(Product product);

    public void edit(long id, Product productUpdated);

    public void delete(long id);
    
    public Product findProductByName(String name);
    
    public List<Product> findProductsByCategory(String categories);
    

}
