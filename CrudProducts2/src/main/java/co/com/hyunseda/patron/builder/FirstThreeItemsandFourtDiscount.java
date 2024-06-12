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
public class FirstThreeItemsandFourtDiscount extends Invoicebuilder{

    @Override
    public void setItems(List<ItemShoppingCart> items) {
         invoice.setItems(items);
    }

    @Override
    public void buildDiscount() {
        //Calculando descuento para el primer item de 3.
       /* double precio= invoice.getItems().get(0).getProduct().getPrice();
        double primerDescuento= precio - (precio * 0.10) ;
         //Calculando descuento para el segundo item de 3.
        double precio2= invoice.getItems().get(1).getProduct().getPrice();
        double secondDescuento= precio2 - (precio2 * 0.10) ;
        //Calculando descuento para el terce item de 3.
         double precio3= invoice.getItems().get(2).getProduct().getPrice();
         double tercerDescuento= precio3 - (precio3 * 0.05) ;
         double descuento = primerDescuento+secondDescuento+tercerDescuento;
        */
       double precio, condescuento,descuento ;
       precio=0;
      condescuento=0;
      descuento=0;
         for(int i=0; i<3;i++){
             precio= invoice.getItems().get(i).getProduct().getPrice();
             
              if(i==2){
               descuento=(descuento+precio * 0.05 )* invoice.getItems().get(i).getAmount() ;
              condescuento= condescuento +  precio - (precio * 0.05)* invoice.getItems().get(i).getAmount();
             }else{
                  descuento=(descuento+precio * 0.10) * invoice.getItems().get(i).getAmount();
                 condescuento= condescuento+ precio - (precio * 0.10)* invoice.getItems().get(i).getAmount(); 
              }
         }
         
         double total=0;
         if(invoice.getItems().get(3)!=null){
           for(int i=3; i<invoice.getItems().size();i++){
               JOptionPane.showMessageDialog(null, "calculando demas items");
               total= total+invoice.getItems().get(i).getProduct().getPrice()*invoice.getItems().get(i).getAmount();
           }
         }
         total=condescuento+total;
         JOptionPane.showMessageDialog(null, "descuento"+condescuento);
        invoice.setTotal(total);
      
        JOptionPane.showMessageDialog(null, "EL TOTAL para el segundo caso ES:"+total);
      //CONSTRUYENDO FACTURA........
      Factura guiFactura= new Factura(invoice,descuento);
      guiFactura.setVisible(true);
    }
    
}
