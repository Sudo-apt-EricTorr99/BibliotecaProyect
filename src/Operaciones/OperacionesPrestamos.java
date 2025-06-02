/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import Conexiones.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ericr
 */
public class OperacionesPrestamos {

    public void realizarDevolucion() {
        try {
            //pedir datos
            String inputUsuario = JOptionPane.showInputDialog(null, "Introduce el ID del usuario:");
            String inputLibro = JOptionPane.showInputDialog(null, "Introduce el ID del libro:");

            //validar entradas
            if (inputUsuario == null || inputLibro == null
                    || inputUsuario.trim().isEmpty() || inputLibro.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            int idUsuario = Integer.parseInt(inputUsuario.trim());
            int idLibro = Integer.parseInt(inputLibro.trim());

            Conexion conexion = new Conexion();
            try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM Prestamos WHERE Id_Usuario = ? AND Id_Libro = ?")) {

                stmt.setInt(1, idUsuario);
                stmt.setInt(2, idLibro);
                int filas = stmt.executeUpdate();

                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Devolución realizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un préstamo con esos datos.");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Introduce solo números enteros.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar devolución: " + e.getMessage());
        }
    }

    //metodo para hacer un prestamo
    public void realizarPrestamo() {
        try {
            //solicita el ID del usuario
            String inputUsuario = JOptionPane.showInputDialog(null, "Introduce el ID del usuario:");
            if (inputUsuario == null || inputUsuario.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            //solicita el ID del libro
            String inputLibro = JOptionPane.showInputDialog(null, "Introduce el ID del libro:");
            if (inputLibro == null || inputLibro.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            int idUsuario = Integer.parseInt(inputUsuario.trim());
            int idLibro = Integer.parseInt(inputLibro.trim());

            Conexion conexion = new Conexion();
            try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Prestamos (Id_Usuario, Id_Libro, Fecha_Prestamo) VALUES (?, ?, ?)")) {

                stmt.setInt(1, idUsuario);
                stmt.setInt(2, idLibro);

                //obtener fecha actual 
                java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());
                stmt.setDate(3, fechaActual);

                int filas = stmt.executeUpdate();

                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el préstamo.");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Introduce solo números enteros.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar el préstamo: " + e.getMessage());
        }
    }

}
