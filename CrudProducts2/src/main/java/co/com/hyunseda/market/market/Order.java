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
public class Order {
   private OrderState state;

    public Order() {
        this.state = new Process();
        
    }
    
    public void setState(OrderState state){
        this.state=state;
    }
    
    public void avanzar(){
        state.avanzar(this);
    }
   
}
