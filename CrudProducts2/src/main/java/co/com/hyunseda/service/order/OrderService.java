/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.service.order;

import co.com.hyunseda.access.order.IOrderRepository;
import co.com.hyunseda.entities.order.Item;
import co.com.hyunseda.entities.order.Order;
import java.util.List;



/**
 *
 * @author X1605
 */
public class OrderService {
   IOrderRepository repo;

    public OrderService(IOrderRepository repo) {
        this.repo = repo;
    }

    public List<Order> findAll() {
        return repo.findAll();
    }
    
    public void create(Order order){
        repo.create(order);
    }
    
    public void publish (Long id){
        repo.publish(id);
    }
}
