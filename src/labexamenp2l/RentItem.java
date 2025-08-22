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
    // Atributos
    private String codigo;         // Código único del ítem
    private String nombre;         // Nombre del ítem
    private double precioBase;     // Precio base de renta
    private int cantidadCopias;    // Cantidad de copias disponibles (inicia en 0)
    private ImageIcon imagen;      // Imagen del ítem (desde archivo en GUI)

    // Constructor que inicializa los 3 primeros atributos; copias en 0
    public RentItem(String codigo, String nombre, double precioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cantidadCopias = 0;  // siempre inicia en 0
    }

    // Método abstracto (debe implementarse en subclases)
    public abstract double pagoRenta(int dias);

    // Getters para los 3 atributos iniciales
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    // Getter y Setter para copias
    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    // Getter y Setter para imagen
    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    // Método toString() redefinido
    @Override
    public String toString() {
        return "Código: " + codigo + 
               ", Nombre: " + nombre + 
               ", Precio Base: " + precioBase + 
               ", Copias: " + cantidadCopias;
    }
}