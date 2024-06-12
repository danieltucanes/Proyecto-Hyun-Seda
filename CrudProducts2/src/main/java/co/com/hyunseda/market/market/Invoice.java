/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.market;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author ACER
 */
public class Invoice {
   
    private String nombre;
    private int id;
    private int numeroFactura;
    private Date fechaEmision;
    private double total;
    private List<ItemShoppingCart> items;
       Random random = new Random();
        
    public Invoice() {
        this.nombre = "Felipe Saruma ";  
        this.id = random.nextInt(); 
        this.numeroFactura = random.nextInt();
        this.fechaEmision = new Date();
    }

    public void setItems(List<ItemShoppingCart> items) {
        this.items = items;
    }

    public List<ItemShoppingCart> getItems() {
        return items;
    }
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }
    
    
    
    
}
