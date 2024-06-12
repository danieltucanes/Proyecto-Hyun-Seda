/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.service.order;

import co.com.hyunseda.market.infra.Subject;
import co.com.hyunseda.entities.order.Item;
import co.com.hyunseda.entities.order.ShoppingCart;
import com.unicauca.clientproducthttpclient.access.ProductRestRepository;
import com.unicauca.clientproducthttpclient.domain.entities.Product;
import com.unicauca.clientproducthttpclient.domain.services.ProductService;

/**
 *
 * @author X1605
 */
public class ShoppingCartService extends Subject{
    private ShoppingCart shoppingCar;
      ProductService service = new ProductService(new ProductRestRepository());
    //ItemRepository service = new Service(new ProductRestRepository());

    public ShoppingCartService(ShoppingCart shoppingCar) {
        this.shoppingCar = shoppingCar;
    }
   
   
   public ShoppingCart getShoppingCar(){
       return shoppingCar;
   }
   public boolean addItem(Item item){
       this.shoppingCar.addItem(item);
        this.notifyAllObserves();
        return true;
    }
   
   public double calculateTotal(){
      double total = 0;
       for(Item items: shoppingCar.getItems()){
           Product product = service.findById(items.getProduct_id());
           total = total + product.getPrice() * items.getAmount();
       }
       return total;
   }
}
