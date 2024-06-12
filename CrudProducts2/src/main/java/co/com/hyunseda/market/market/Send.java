/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.market;

import co.com.hyunseda.market.infra.OrderState;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Send implements OrderState{

    @Override
    public void avanzar(Order order) {
         System.out.println("HOLA , POR FAVOR DIME SI TU PEDIDO FUE RECIBIDO. marca:");
         System.out.println("1. PARA RECIBIDO");
         System.out.println("2. PARA NO RECIBIDO :( :(;(");
         Scanner leer = new Scanner(System.in);
         int opcion= leer.nextInt();
         if(opcion==1){
             System.out.println("su pedido  ha sido recibido, cambiando estado recibido..");
            order.setState(new Receive());
            
         }else{
              System.out.println("su pedido  ha sido canselado, cambiando estado canselado..");
               order.setState(new Cancel());
         }
         
    }
    
}
