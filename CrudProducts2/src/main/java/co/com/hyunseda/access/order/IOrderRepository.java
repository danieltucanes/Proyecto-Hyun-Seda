/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.access.order;

import co.com.hyunseda.entities.order.Order;
import java.util.List;



/**
 *
 * @author X1605
 */
public interface IOrderRepository {
   public List<Order> findAll();

    Order findById(int id);
    public void publish(Long id);
    
    public void create(Order order);

    public void edit(int id, Order orderUpdated);

    public void delete(int id);
}
