/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labexamenp2l;

import java.util.Date;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;

/**
 *
 * @author Mayra Bardales
 */

public class Movie extends RentItem {
    private Date fechaEstreno;

    public Movie(String codigo, String nombre, double precioBase) {
        super(codigo, nombre, precioBase);
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    // Aquí usamos el JDateChooser directamente
    public void seleccionarFechaEstreno() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Fecha de Estreno:"));
        JDateChooser dateChooser = new JDateChooser();
        panel.add(dateChooser);

        int result = JOptionPane.showConfirmDialog(null, panel, "Seleccione Fecha de Estreno", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION && dateChooser.getDate() != null) {
            this.fechaEstreno = dateChooser.getDate();
        }
    }

    @Override
    public double getTotal(int dias) {
        // Ejemplo: precio base * días
        return getPrecioBase() * dias;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nFecha de estreno: " + (fechaEstreno != null ? fechaEstreno.toString() : "No definida");
    }

    @Override
    public double pagoRenta(int dias) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
