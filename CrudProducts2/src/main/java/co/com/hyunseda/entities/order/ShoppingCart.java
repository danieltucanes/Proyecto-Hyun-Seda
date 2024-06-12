/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.entities.order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe Castro
 */
public class ShoppingCart {
    private List<Item> items;
    //private List<Observador> observadores;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        //this.observadores = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }
    
    public void addItem(Item item){
        items.add(item);
    }
}
