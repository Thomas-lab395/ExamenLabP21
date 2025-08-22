/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labexamenp2l;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Mayra Bardales
 */
public class Movie extends RentItem {

    private Date fechaEstreno;


    public Movie(String codigo, String nombre, double precioBase) {
        super(codigo, nombre, precioBase);
        this.fechaEstreno = new Date();
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getEstado() {
        Calendar hoy = Calendar.getInstance();
        Calendar estreno = Calendar.getInstance();
        estreno.setTime(fechaEstreno);

        int diffYears = hoy.get(Calendar.YEAR) - estreno.get(Calendar.YEAR);
        int diffMonths = diffYears * 12 + (hoy.get(Calendar.MONTH) - estreno.get(Calendar.MONTH));

        if (diffMonths <= 3) {
            return "ESTRENO";
        } else {
            return "NORMAL";
        }
    }

    @Override
    public String toString() {
        return super.toString() + 
               ", Estado: " + getEstado() + 
               " – Movie";
    }

    @Override
    public double pagoRenta(int dias) {
        double total = getPrecioBase() * dias;

        if (getEstado().equals("ESTRENO")) {
            if (dias > 2) {
                int extra = dias - 2;
                total += extra * 50; 
            }
        } else {
            if (dias > 5) {
                int extra = dias - 5;
                total += extra * 30; 
            }
        }

        return total;
    }
}

