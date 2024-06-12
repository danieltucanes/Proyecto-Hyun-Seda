/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.entities.order;

import co.com.hyunseda.entities.order.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author X1605
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("state")
    private String state;
    @JsonProperty("date")
    private Timestamp date;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<>();

    public Order() {
    }
    
    
    public Order(String state, Timestamp date,List<Item> items ) {
        this.state = state;
        this.date = date;
        this.items = items;
    }

    

    public Order(String state, Timestamp fechaYHoraActual) {
        this.state = state;
        this.date = fechaYHoraActual;
    }

    public Long getId() {
        return id;
    }

   

    public String getState() {
        return state;
    }

    public Timestamp getDate() {
        return date;
    }

    public List<Item> getItems() {
        return items;
    }


    public void setState(String state) {
        this.state = state;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
     
    
}
