/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.market;

/**
 *
 * @author ACER
 */
public class Cliente {
   private String nombre;
   private long cedula;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public Cliente(String nombre, long cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
    public Cliente() {
        
    }
    
    
}
