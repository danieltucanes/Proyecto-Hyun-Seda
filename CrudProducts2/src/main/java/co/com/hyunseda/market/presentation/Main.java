
package co.com.hyunseda.market.presentation;

/*
import co.com.hyunseda.market.access.FactoryCategory;
import co.com.hyunseda.market.access.FactoryProduct;
import co.com.hyunseda.market.access.ICategoryRepository;
import co.com.hyunseda.market.access.IProductRepository;
import co.com.hyunseda.market.market.Category;
import co.com.hyunseda.market.market.Product;
import co.com.hyunseda.market.presentation.GUIProducts;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;*/
import co.unicauca.microkernel.plugin.manager.DeliveryPluginManager;
import com.raven.main.GUIMain;
import com.unicauca.clientproducthttpclient.access.CategoryRestRepository;
import com.unicauca.clientproducthttpclient.access.ProductRestRepository;
import com.unicauca.clientproducthttpclient.domain.entities.Category;
import com.unicauca.clientproducthttpclient.domain.entities.Product;
import com.unicauca.clientproducthttpclient.domain.services.CategoryService;
import com.unicauca.clientproducthttpclient.domain.services.ProductService;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
       
       ProductService service = new ProductService(new ProductRestRepository());
       CategoryService serviceC = new CategoryService(new CategoryRestRepository());
        
       
       Category cat = new Category("aretes");
       Category cat2 = new Category("pendientes"); 
       //categoria ruana
       Category cat3 = new Category("ruana");
       Category cat4 = new Category("estampadas");
       // categoria pañoleta
       Category cat5 = new Category("panoletas");
       Category cat6 = new Category("estampadas");
       
       
       
       
       serviceC.create(cat);
       serviceC.create(cat2);
       serviceC.create(cat3);
       serviceC.create(cat4);
       serviceC.create(cat5);
       serviceC.create(cat6);
       
        cat.setCategoryId((long)1);
        cat2.setCategoryId((long)2);
        cat3.setCategoryId((long)3);
        cat4.setCategoryId((long)4);
        cat5.setCategoryId((long)5);
        cat6.setCategoryId((long)6);
       
  
         List<Category> listaC = new ArrayList<>();
         List<Category> lista = new ArrayList<>();
         List<Category> listaP = new ArrayList<>();
         
        listaP.add(cat5);
        listaC.add(cat3);
        listaC.add(cat4);
        lista.add(cat);
        lista.add(cat2);
        
        Product product1 = new Product("Aretes", 20000, "\\src\\main\\java\\com\\raven\\image\\a.png", "Arestes Rosados", "aretes-rosados", 2, "arete,pendiente,accersorio,joyeria", "Arete de porselana,largo 6cm, ancho 3 cm", lista);
        Product product2 = new Product("Aretes", 30000, "\\src\\main\\java\\com\\raven\\image\\aM.png", "Arestes De seda Multicolor", "aretes-multicolor", 1, "arete,pendiente,accersorio,joyeria", "Arete de porselana,largo 6cm, ancho 3 cm", listaC);
        Product product3 = new Product("Aretes", 25000, "\\src\\main\\java\\com\\raven\\image\\amr.png", "Aretes De seda Azul", "aretes-azul", 2, "arete,pendiente,accersorio,joyeria", "Arete de porselana,largo 6cm, ancho 3 cm", lista);
        Product product4 = new Product("Panoleta", 90000, "\\src\\main\\java\\com\\raven\\image\\pa.png", "Panoleta Dorada Naranja", "panholeta-dorada-naranja", 2, "arete,pendiente,accersorio,joyeria", "Arete de porselana,largo 6cm, ancho 3 cm", listaP);
        Product product5 = new Product("Ruana", 330000, "\\src\\main\\java\\com\\raven\\image\\ru.png", "Ruana Azul", "ruana-azul", 2, "Ruana,poncho,abrigo,ropainvierno", "Ruana Azul largo 128, ancho 128", listaC);
        
        service.create(product1);
        
        service.create(product2);
        service.create(product3);
        service.create(product4);
        service.create(product5);
        
        GUIInicio instanceI = new GUIInicio( );
        
        // La ventana instance recibia como parametro,categoryService, productService
        GUIProducts instance = new GUIProducts();
        
        //la ventana instance2 Recibia como parametro: categoryService.
        
        GUICategory instance2 = new GUICategory();

        instanceI.setVisible(true);
         String basePath = getBaseFilePath();
        try {
            DeliveryPluginManager.init(basePath);

         //   Consola presentationObject = new Consola();
           // presentationObject.start();

        } catch (Exception ex) {
            Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }
        
         
        instanceI.setVisible(true);
    }
    
        private static String getBaseFilePath() {
        try {
            String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters.
            File pathFile = new File(path);
            if (pathFile.isFile()) {
                path = pathFile.getParent();
                
                if (!path.endsWith(File.separator)) {
                    path += File.separator;
                }
                
            }

            return path;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al eliminar espacios en la ruta del archivo", ex);
            return null;
        }
    }
     
    

}
