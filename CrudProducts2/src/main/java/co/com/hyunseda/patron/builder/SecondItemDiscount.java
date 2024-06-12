/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.patron.builder;

import co.com.hyunseda.market.market.ItemShoppingCart;
import co.com.hyunseda.market.presentation.Factura;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class SecondItemDiscount  extends  Invoicebuilder{

    @Override
    public void setItems(List<ItemShoppingCart> items) {
            invoice.setItems(items);
            
    }

    @Override
    public void buildDiscount() {
      double precio= invoice.getItems().get(0).getProduct().getPrice();
      double condescuento= precio+ precio - (precio * 0.10) ;
      double descuento=precio * 0.10;
      
      
       double total=0;
         if(invoice.getItems().size()>1){
           for(int i=1; i<invoice.getItems().size();i++){
               JOptionPane.showMessageDialog(null, "calculando demas items");
               
               total= total+invoice.getItems().get(i).getProduct().getPrice()*invoice.getItems().get(i).getAmount();
               
           }
         }
         total=total+condescuento;
      invoice.setTotal(total);
      JOptionPane.showMessageDialog(null, "primera polita EL TOTAL ES:"+total);
        Factura guiFactura= new Factura(invoice,descuento);
        guiFactura.setVisible(true);
        
      //CONSTRUYENDO FACTURA........
      
      
    }
    
}
