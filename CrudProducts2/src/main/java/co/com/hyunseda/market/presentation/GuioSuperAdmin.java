/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.com.hyunseda.market.presentation;

import com.unicauca.clientuserhttpclient.presentation.GUIUserOption;

/**
 *
 * @author ACER
 */
public class GuioSuperAdmin extends javax.swing.JFrame {

    /**
     * Creates new form GuioSuperAdmin
     */
    String token;
    public GuioSuperAdmin(String token) {
        initComponents();
        this.token =token;
    }

    private GuioSuperAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Productos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1btnProductsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jButton1, gridBagConstraints);

        jButton4.setText("Categorias");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4btnCategoriesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jButton4, gridBagConstraints);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2btnCloseActionPerformed

    private void jButton1btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1btnProductsActionPerformed
        // TODO add your handling code here:
        // se le pasaba categoryService, productService , En la ventana instance
        GUIProducts instance = new GUIProducts();
        instance.setVisible(true);
    }//GEN-LAST:event_jButton1btnProductsActionPerformed

    private void jButton4btnCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4btnCategoriesActionPerformed
        // TODO add your handling code here:

        //anteriormente resicibia categoryService

        GUICategory instance = new GUICategory();

        instance.setVisible(true);
    }//GEN-LAST:event_jButton4btnCategoriesActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        
        GUIUserOption instanciaRegistrarUsuario = new GUIUserOption(token);
        instanciaRegistrarUsuario.setVisible(true);
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
