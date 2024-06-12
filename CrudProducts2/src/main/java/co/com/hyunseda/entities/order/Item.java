/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.entities.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
     @JsonProperty("amount")
    private int amount;
    
     /*
    @JsonProperty("product")
    private ProductRequest product;
     */
    @JsonProperty("product_id")
    private long product_id;
    
    @JsonIgnore
    @JsonProperty("order")
    private Order order;
    
    /*
    public void setProduct(ProductRequest product) {
        this.product = product;
    }*/
    
    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setOrder(Order order){
        this.order = order;
    }
    /*
    public ProductRequest getProduct() {
        return product;
    }*/

    public int getAmount() {
        return amount;
    }
    
}
