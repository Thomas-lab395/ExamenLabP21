/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labexamenp2l;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author Mayra Bardales
 */

public class Game extends RentItem implements MenuActions {

    private Calendar fechaPublicacion;
    private ArrayList<String> especificaciones;

    public Game(String codigo, String nombre) {
        super(codigo, nombre, 20.0);
        this.fechaPublicacion = Calendar.getInstance();
        this.especificaciones = new ArrayList<>();
    }

    public void setFechaPublicacion(int year, int mes, int dia) {
        fechaPublicacion.set(Calendar.YEAR, year);
        fechaPublicacion.set(Calendar.MONTH, mes - 1);
        fechaPublicacion.set(Calendar.DAY_OF_MONTH, dia);
    }

    public Calendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void listEspecificaciones() {
        listEspecificacionesRec(0);
    }

    private void listEspecificacionesRec(int index) {
        if (index < especificaciones.size()) {
            System.out.println("- " + especificaciones.get(index));
            listEspecificacionesRec(index + 1);
        }
    }

    public void addEspecificacion(String esp) {
        especificaciones.add(esp);
    }

    @Override
    public String toString() {
        int year = fechaPublicacion.get(Calendar.YEAR);
        int month = fechaPublicacion.get(Calendar.MONTH) + 1;
        int day = fechaPublicacion.get(Calendar.DAY_OF_MONTH);

        return super.toString() +
                ", Fecha Publicación: " + day + "/" + month + "/" + year +
                " – PS3 Game";
    }

    @Override
    public double pagoRenta(int dias) {
        return 20.0 * dias;
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                JPanel panel = new JPanel();
                panel.add(new JLabel("Nueva Fecha de Publicación:"));
                JDateChooser dateChooser = new JDateChooser();
                panel.add(dateChooser);

                int result = JOptionPane.showConfirmDialog(null, panel, "Seleccionar Fecha", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION && dateChooser.getDate() != null) {
                    Calendar fecha = Calendar.getInstance();
                    fecha.setTime(dateChooser.getDate());
                    setFechaPublicacion(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH) + 1, fecha.get(Calendar.DAY_OF_MONTH));
                    JOptionPane.showMessageDialog(null, "Fecha de publicación actualizada.");
                }
                break;

            case 2:
                String esp = JOptionPane.showInputDialog("Ingrese nueva especificación:");
                addEspecificacion(esp);
                JOptionPane.showMessageDialog(null, "Especificación agregada.");
                break;

            case 3:
                StringBuilder sb = new StringBuilder("Especificaciones del juego:\n");
                for (String e : especificaciones) {
                    sb.append("- ").append(e).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
        }
    }

    @Override
    public void submenu() {
        String menu = """
                      --- Submenú Juego ---
                      1. Actualizar fecha de publicación
                      2. Agregar especificación
                      3. Ver especificaciones
                      """;
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        ejecutarOpcion(opcion);
    }
}