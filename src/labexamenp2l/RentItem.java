/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labexamenp2l;

import javax.swing.ImageIcon;

/**
 *
 * @author Mayra Bardales
 */


public abstract class RentItem {
    private String codigo;         
    private String nombre;         
    private double precioBase;     
    private int cantidadCopias;    
    private ImageIcon imagen;      

    public RentItem(String codigo, String nombre, double precioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cantidadCopias = 0;  
    }

    public abstract double pagoRenta(int dias);

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + 
               ", Nombre: " + nombre + 
               ", Precio Base: " + precioBase + 
               ", Copias: " + cantidadCopias;
    }
}
