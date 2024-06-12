/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.market;

import co.com.hyunseda.market.infra.OrderState;

/**
 *
 * @author ACER
 */
public class Ship implements  OrderState{

    @Override
    public void avanzar(Order order) {
         System.out.println("su pedido  va ser enviado");
         order.setState(new Send());
    }
    
}
