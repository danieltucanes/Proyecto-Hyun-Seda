/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.unicauca.clientproducthttpclient.access;


import com.unicauca.clientproducthttpclient.domain.entities.Category;
import com.unicauca.clientproducthttpclient.domain.entities.Product;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ICategoryRepository {
      public List<Category> findAll();

    Product findById(long id);

    public void create(Category category);

    public void edit(long id, Category categoryUpdated);

    public void delete(long id);
    
    
}
