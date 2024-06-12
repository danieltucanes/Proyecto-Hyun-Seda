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
// clase director
public class Facturador {
    private Invoicebuilder Invoicebuilder;

    public void setInvoicebuilder(Invoicebuilder fc){
      Invoicebuilder = fc;
    }
    
    public Invoice getIncoice(){
        return Invoicebuilder.getInvoice();
    }
    
    public void constuirFactura(List<ItemShoppingCart> items){
        Invoicebuilder.crearNuevaFactura();
        Invoicebuilder.setItems(items);
        Invoicebuilder.buildDiscount();
    }
    
    
    
    
    
}
