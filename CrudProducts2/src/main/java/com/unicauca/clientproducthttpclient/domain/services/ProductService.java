package com.unicauca.clientproducthttpclient.domain.services;

import com.unicauca.clientproducthttpclient.access.IProductRepository;
import com.unicauca.clientproducthttpclient.domain.entities.Product;
import java.util.List;

public class ProductService {

    IProductRepository repo;

    public ProductService(IProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public void create(Product product){
        repo.create(product);
    }
     public Product findById(long id){
         return repo.findById(id);
      }
     public void delete(long id){
         repo.delete(id);
     }
     public void edit(long id, Product productUpdated){
         repo.edit(id,productUpdated);
     }
     public Product findProductByName(String name){
        return repo.findProductByName(name);
     }
     
    public List<Product> findProductsByCategory(String categories) {
        return repo.findProductsByCategory(categories);
    }
 
}
