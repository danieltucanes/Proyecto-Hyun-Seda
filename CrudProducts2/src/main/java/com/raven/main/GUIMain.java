/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.raven.main;


import co.com.hyunseda.entities.order.ShoppingCart;
import com.raven.event.EventItem;
import com.raven.form.FormHome;
import com.raven.model.ModelItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;




import co.com.hyunseda.market.presentation.Messages;

import co.com.hyunseda.presentation.order.GUIProductInfo;

import co.com.hyunseda.presentation.order.GUIShoppingCart;
import co.com.hyunseda.service.order.ShoppingCartService;
import com.unicauca.clientproducthttpclient.access.CategoryRestRepository;
import com.unicauca.clientproducthttpclient.access.ProductRestRepository;
import com.unicauca.clientproducthttpclient.domain.entities.Product;
import com.unicauca.clientproducthttpclient.domain.services.CategoryService;
import com.unicauca.clientproducthttpclient.domain.services.ProductService;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ACER
 */
public class GUIMain extends javax.swing.JFrame {

    /**
     * Creates new form GUIMain
     */
    
    private FormHome home;
    private Animator animator;
    private Point animatePoint;
    private ModelItem itemSelected;
      ProductService productService = new ProductService(new ProductRestRepository());
      CategoryService categoryService = new CategoryService(new CategoryRestRepository());
    //private ShoppingCarService shoppingCarService;
    
    private ShoppingCart shoppingCar = new ShoppingCart();
    private ShoppingCartService shoppingCarService = new ShoppingCartService(shoppingCar);
    
    GUIShoppingCart shoppingCartGraphic = new GUIShoppingCart(shoppingCarService);
    /*
    public GUIMain() {
        initComponents();
         setBackground(new Color(0, 0, 0, 0));
         init();
         initializeTable();
          //  Animator start form animatePoint to TagetPoint
        animator = PropertySetter.createAnimator(500, mainPanel1, "imageLocation", animatePoint, mainPanel1.getTargetLocation());
        animator.addTarget(new PropertySetter(mainPanel1, "imageSize", new Dimension(180, 120), mainPanel1.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void end() {
                mainPanel1.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
    }
    */
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMain().setVisible(true);
            }
        });
    }
    
      public GUIMain() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
         init();
         initializeTable();
          //  Animator start form animatePoint to TagetPoint
        animator = PropertySetter.createAnimator(500, mainPanel1, "imageLocation", animatePoint, mainPanel1.getTargetLocation());
        animator.addTarget(new PropertySetter(mainPanel1, "imageSize", new Dimension(180, 120), mainPanel1.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void end() {
                mainPanel1.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        initializeTable();
        this.shoppingCarService = shoppingCarService;
      
        setLocationRelativeTo(null); //centrar al ventana
        shoppingCarService.addObserver(shoppingCartGraphic);
    }
     private void init() {
       home = new FormHome();
        winButton.initEvent(this, background1);
        mainPanel1.setLayout(new BorderLayout());
        mainPanel1.add(home);
        findData();
    }
      private void testData() {
          
        home.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                if (itemSelected != null) {
                    mainPanel1.setImageOld(itemSelected.getImage());
                    
                    System.out.println("item, seleccionado"+item.getItemID());
                }
                if (itemSelected != item) {
                    if (!animator.isRunning()) {
                        itemSelected = item;
                        
                        animatePoint = getLocationOf(com);
                        mainPanel1.setImage(item.getImage());
                        mainPanel1.setImageLocation(animatePoint);
                        mainPanel1.setImageSize(new Dimension(500, 200));
                        mainPanel1.repaint();
                        home.setSelected(com);
                        home.showItem(item);
                        animator.start();
                        agregarProductoATabla(item);
                    }
                }
            }
        });
       
        int ID = 1;
        for (int i = 0; i <= 5; i++) {
           
        //home.addItem(new ModelItem(ID++, "4DFWD PULSE", "This product is excluded from all promotional discounts and offers.", 160, "Adidas", new ImageIcon(getClass().getResource(System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\img2.png"))));
        String rutaRelativa = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\a.png";
        String rutaRelativa2 = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\aM.png";
        String rutaRelativa3 = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\amr.png";
        String rutaRelativa4 = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\pa.png";
        String rutaRelativa5 = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\ru.png";
       // ImageIcon iconoOriginal = new ImageIcon(rutaRelativa);
        //Image imagenOriginal = iconoOriginal.getImage();
        //Image imagenEscalada = imagenOriginal.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
       // ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
       
        home.addItem(new ModelItem(ID++, "Hyunseda", "Aretes Rosados", 20000, "Aretes", new ImageIcon(rutaRelativa)));
        home.addItem(new ModelItem(ID++, "Hyunseda", "Aretes De seda Multicolor AD42", 30000, "Aretes", new ImageIcon(rutaRelativa2)));
        home.addItem(new ModelItem(ID++, "Hyunseda", "Aretes De seda Azul.", 25000, "Aretes", new ImageIcon(rutaRelativa3)));
        home.addItem(new ModelItem(ID++, "Hyunseda", "Pañoleta Dorada Naranja.", 90000, "Pañolea", new ImageIcon(rutaRelativa4)));
        home.addItem(new ModelItem(ID++, "Hyunseda", "Ruana verde y negra ", 330000, "Ruana", new ImageIcon(rutaRelativa5)));
        
        
        }
         
    }
      
      
    private void findData() {
          
        home.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                if (itemSelected != null) {
                    mainPanel1.setImageOld(itemSelected.getImage());
                    
                    System.out.println("item, seleccionado"+item.getItemID());
                }
                if (itemSelected != item) {
                    if (!animator.isRunning()) {
                        itemSelected = item;
                        
                        animatePoint = getLocationOf(com);
                        mainPanel1.setImage(item.getImage());
                        mainPanel1.setImageLocation(animatePoint);
                        mainPanel1.setImageSize(new Dimension(500, 200));
                        mainPanel1.repaint();
                        home.setSelected(com);
                        home.showItem(item);
                        animator.start();
                        agregarProductoATabla(item);
                    }
                }
            }
        });
       
        //String rutaRelativa = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\a.png";
        String rutaRelativa2 = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\aM.png";
        String rutaRelativa3 = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\amr.png";
        String rutaRelativa4 = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\pa.png";
        String rutaRelativa5 = System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\ru.png";
        
        List<Product> products = productService.findAll();
        int ID = 1;
        for (int i = 0; i < products.size(); i++) {
           
            
            
            //home.addItem(new ModelItem(ID++, "4DFWD PULSE", "This product is excluded from all promotional discounts and offers.", 160, "Adidas", new ImageIcon(getClass().getResource(System.getProperty("user.dir") + "\\src\\main\\java\\com\\raven\\image\\img2.png"))));
            
           // ImageIcon iconoOriginal = new ImageIcon(rutaRelativa);
            //Image imagenOriginal = iconoOriginal.getImage();
            //Image imagenEscalada = imagenOriginal.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
           // ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
           
            String rutaRelativa = System.getProperty("user.dir") + products.get(i).getImages();
            ModelItem item = new ModelItem();
            item.setItemID((int) products.get(i).getProductId());
            item.setItemName(products.get(i).getName());
            item.setDescription(products.get(i).getDescription());
            item.setPrice(products.get(i).getPrice());
            item.setBrandName(products.get(i).getKeywords());
            item.setImage(new ImageIcon(rutaRelativa));

            home.addItem(item);
            /*home.addItem(new ModelItem(ID++, "Hyunseda", "Aretes Rosados", 20000, "Aretes", new ImageIcon(rutaRelativa)));
            home.addItem(new ModelItem(ID++, "Hyunseda", "Aretes De seda Multicolor AD42", 30000, "Aretes", new ImageIcon(rutaRelativa2)));
            home.addItem(new ModelItem(ID++, "Hyunseda", "Aretes De seda Azul.", 25000, "Aretes", new ImageIcon(rutaRelativa3)));
            home.addItem(new ModelItem(ID++, "Hyunseda", "Pañoleta Dorada Naranja.", 90000, "Pañolea", new ImageIcon(rutaRelativa4)));
            home.addItem(new ModelItem(ID++, "Hyunseda", "Ruana verde y negra ", 330000, "Ruana", new ImageIcon(rutaRelativa5)));*/
        
        
        }
         
    }
      
      private void agregarProductoATabla(ModelItem item) {
    // Obtener el DefaultTableModel asociado a la tabla tblProducts
    DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

    // Crear un arreglo de objetos para representar una fila en la tabla
    Object[] fila = {item.getItemID(), item.getItemName(), item.getDescription(), item.getPrice()};

    // Agregar la fila a la tabla
    model.addRow(fila);
}
      
    private Point getLocationOf(Component com) {
        Point p = home.getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }
    
    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id","Name", "Description"
                }
        ));
    }
     private void fillTable(List<Product> listProducts) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel)  tblProducts.getModel();

        Object rowData[] = new Object[3];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductId();
            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();
            
            model.addRow(rowData);
        }
       
    }
private void fillProduct(Product p) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[3];//No columnas
        rowData[0] = p.getProductId();
        rowData[1] = p.getName();
        rowData[2] = p.getDescription();
        model.addRow(rowData);
    }
private static List<Object[]> obtenerElementosSeleccionados(javax.swing.JTable table) {
        int[] filasSeleccionadas = table.getSelectedRows();
        List<Object[]> elementosSeleccionados = new ArrayList<>();

        for (int fila : filasSeleccionadas) {
            Object[] datosFila = new Object[table.getColumnCount()];
            for (int columna = 0; columna < table.getColumnCount(); columna++) {
                datosFila[columna] = table.getValueAt(fila, columna);
            }
            elementosSeleccionados.add(datosFila);
        }

        return elementosSeleccionados;
    }
    
    
    @SuppressWarnings("unchecked")
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new com.raven.swing.Background();
        header = new javax.swing.JPanel();
        winButton = new com.raven.swing.win_button.WinButton();
        logo1 = new com.raven.component.Logo();
        txtSearch = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        mainPanel1 = new com.raven.swing.MainPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btnAgComp = new javax.swing.JButton();
        btnCarr = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCategories = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        header.setOpaque(false);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(winButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(88, Short.MAX_VALUE))))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(winButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanel1Layout = new javax.swing.GroupLayout(mainPanel1);
        mainPanel1.setLayout(mainPanel1Layout);
        mainPanel1Layout.setHorizontalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanel1Layout.setVerticalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        btnAgComp.setText("Agregar Carrito Compra");
        btnAgComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgCompActionPerformed(evt);
            }
        });

        btnCarr.setText("Carrito Compra");
        btnCarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarrActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listCategories);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Categorias:");

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(background1Layout.createSequentialGroup()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(background1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addComponent(mainPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(background1Layout.createSequentialGroup()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCarr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(background1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnAgComp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCarr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addGroup(background1Layout.createSequentialGroup()
                        .addComponent(mainPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(139, 139, 139)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrActionPerformed
        // TODO add your handling code here:
        shoppingCartGraphic.setVisible(true);
        
    }//GEN-LAST:event_btnCarrActionPerformed

    private void btnAgCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgCompActionPerformed
     // TODO add your handling code here:
     //implementando patron builder 
         
        GUIProductInfo info = new GUIProductInfo(shoppingCarService);
        info.setVisible(true);
        // Aquí puedes trabajar con la lista de elementos seleccionados
            System.out.println("ID ITEM SELECCIONADO");
            long id = (long)itemSelected.getItemID();
            System.out.println(id);
            Product product = productService.findById(id);
            System.out.println("ID ITEM SELECCIONADO");
            System.out.println(product.getProductId());
            /*product.setProductId((Long) fila[0]);
            product.setName(fila[1].toString());
            product.setDescription(fila[2].toString());*/
            info.setProduct(product);
            info.mostrarInfo();
        
    }//GEN-LAST:event_btnAgCompActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
 

            if(!(txtSearch.getText().equals(""))){
                Long c = null;
                try{
                    c = Long.parseLong(txtSearch.getText());
                    if(productService.findById(c) == null){
                        Messages.showMessageDialog("No se han encontrado resultados de la busqueda", "Atención");
                    }else{
                        fillProduct(productService.findById(c));
                    }
                }catch(NumberFormatException e){
                    Messages.showMessageDialog("Ha ingresado caracteres que no son numeros, se esperaba la id de un producto", "Atención");
                }
            }else{
                Messages.showMessageDialog("Debe ingresar el id el producto", "Atención");
            }
            /*
            if(!(txtSearch.getText().equals(""))){
                if(!productService.findProductByName(txtSearch.getText().isEmpty())){
                    fillTable((List<Product>) productService.findProductByName(txtSearch.getText()));
                }else{
                    Messages.showMessageDialog("No se han encontrado resultados de la busqueda", "Atención");
                }
            }else{
                Messages.showMessageDialog("Debe ingresar el nombre del producto", "Atención");
            }
            {
            List<String> catSelect = listCategories.getSelectedValuesList();
            fillTable(productService.findByCategories(catSelect));
        }*/
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Background background1;
    private javax.swing.JButton btnAgComp;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCarr;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listCategories;
    private com.raven.component.Logo logo1;
    private com.raven.swing.MainPanel mainPanel1;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    private com.raven.swing.win_button.WinButton winButton;
    // End of variables declaration//GEN-END:variables

    

}
