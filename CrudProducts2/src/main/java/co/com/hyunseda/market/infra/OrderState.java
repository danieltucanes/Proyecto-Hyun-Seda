/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.market.infra;

import co.com.hyunseda.market.market.Order;

/**
 *
 * @author ACER
 */
public interface OrderState {
  
    public void avanzar(Order order);
    
}
