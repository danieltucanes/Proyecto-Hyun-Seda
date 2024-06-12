/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.clientproducthttpclient.domain.services;

import com.unicauca.clientproducthttpclient.access.ICategoryRepository;
import com.unicauca.clientproducthttpclient.domain.entities.Category;
import java.util.List;

/**
 *
 * @author ACER
 */
public class CategoryService {
    ICategoryRepository cate;

    public CategoryService(ICategoryRepository cate) {
        this.cate = cate;
    }
    
     public List<Category> findAll() {
        return cate.findAll();
        
    }
    public void create(Category category){
       cate.create(category);
    }
    
    public void edit(long id, Category categoryUpdated){
        cate.edit(id, categoryUpdated);
    }
    
     public void delete(long id){
         cate.delete(id);
     }
    
}
