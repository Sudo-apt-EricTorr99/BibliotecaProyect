/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ericr
 */
public class EnlistarLibros {

    public void listarLibros() {
        Conexion conexion = new Conexion();
        String sql = "SELECT Id_Libro, Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento FROM Libros";
        ArrayList<String> libros = new ArrayList<>();

        try (Connection conn = conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("Id_Libro");
                String nombre = rs.getString("Nombre");
                int idAutor = rs.getInt("Id_Autor");
                int idEditorial = rs.getInt("Id_Editorial");
                Date fecha = rs.getDate("Fecha_Lanzamiento");

                String linea = "ID: " + id + " | Título: " + nombre
                        + " | ID Autor: " + idAutor
                        + " | ID Editorial: " + idEditorial
                        + " | Fecha: " + (fecha != null ? fecha.toString() : "N/A");

                libros.add(linea);
            }

            if (libros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay libros registrados.");
            } else {
                StringBuilder mensaje = new StringBuilder("Listado de Libros:\n");
                for (String libro : libros) {
                    mensaje.append(libro).append("\n");
                }
                JOptionPane.showMessageDialog(null, mensaje.toString());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar libros: " + e.getMessage());
        }
    }

    public DefaultTableModel obtenerModeloLibros() {
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("ID Autor");
        modelo.addColumn("ID Editorial");
        modelo.addColumn("Fecha Lanzamiento");

        String sql = "SELECT Id_Libro, Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento FROM Libros";

        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("Id_Libro");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getInt("Id_Autor");
                fila[3] = rs.getInt("Id_Editorial");
                fila[4] = rs.getDate("Fecha_Lanzamiento");

                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener libros: " + e.getMessage());
        }

        return modelo;
    }

}
