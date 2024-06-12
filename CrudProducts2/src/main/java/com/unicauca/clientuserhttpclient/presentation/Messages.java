/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.clientuserhttpclient.presentation;

import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Castro
 */
class Messages {
    public static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int errorMessageDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
