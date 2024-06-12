/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.patron.builder;

import co.com.hyunseda.market.market.Invoice;
import co.com.hyunseda.market.market.ItemShoppingCart;
import java.util.List;

/**
 *
 * @author ACER
 */
public abstract class Invoicebuilder {
    protected Invoice invoice;
    
    public Invoice getInvoice() { 
    return this.invoice;
  }
  
    public void crearNuevaFactura() {
    this.invoice = new Invoice();
   }
  public abstract void setItems(List<ItemShoppingCart> items);
  public abstract void buildDiscount();
  
     
}
