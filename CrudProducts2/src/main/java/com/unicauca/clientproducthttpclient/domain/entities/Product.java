package com.unicauca.clientproducthttpclient.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty("productId")
    private long productId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private double price;
    
    @JsonProperty("description")
    private String description;
    
     @JsonProperty("slug")
    private String slug;
     
     @JsonProperty("stock")
    private int stock;
    
     @JsonProperty("keywords")
    private String keywords;
     
    @JsonProperty("images")
    private String images;


    @JsonProperty("characteristics")
    private String characteristics;
    
     //@JsonProperty("createAt")
     //private Date createAt;
     
    @JsonProperty("categories")
    private List<Category> categories;
    
   
    

    public Product() {

    }

    public Product(String name, double price, String images, String description, String slug, int stock, String keywords, String characteristics, List<Category> categories) {
        this.name = name;
        this.price = price;
        this.images = images;
        this.description = description;
        this.slug = slug;
        this.stock = stock;
        this.keywords = keywords;
        this.characteristics = characteristics;
        this.categories = categories;
        //this.createAt = createAt;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    

   

   
    
    
    
    

}
