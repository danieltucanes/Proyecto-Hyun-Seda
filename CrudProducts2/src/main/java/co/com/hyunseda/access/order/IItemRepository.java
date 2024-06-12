/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.access.order;


import co.com.hyunseda.entities.order.Item;
import java.util.List;

/**
 *
 * @author X1605
 */
public interface IItemRepository {
    public List<Item> findAll();
    
    public List<Item> itemsByOrder(Long id);
    
    Item findById(int id);

    public void create(Item item);

    public void edit(int id, Item itemUpdate);

    public void delete(int id);
}
