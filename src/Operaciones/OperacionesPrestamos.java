/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import Conexiones.Conexion;  // Importamos nuestra clase de conexión personalizada a la BD
import java.sql.*; // Importamos todo lo necesario para trabajar con SQL en Java
import javax.swing.JOptionPane; // Importamos esta clase para mostrar cuadros de diálogo

/**
 *
 * @author ericr
 */
public class OperacionesPrestamos {
//método que se encarga de hacer una devolución de un libro prestado

    public void realizarDevolucion() {
        try {
            //le pedimos al usuario que introduzca el ID del usuario
            String inputUsuario = JOptionPane.showInputDialog(null, "Introduce el ID del usuario:");
            //lke pedimos al usuario que introduzca el ID del libro
            String inputLibro = JOptionPane.showInputDialog(null, "Introduce el ID del libro:");

            //validamos si el usuario canceló o dejó los campos vacíos
            if (inputUsuario == null || inputLibro == null
                    || inputUsuario.trim().isEmpty() || inputLibro.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;  //salimos del método si la entrada no es válida
            }

            //convertimos los valores ingresados a enteros (ID de usuario y de libro)
            int idUsuario = Integer.parseInt(inputUsuario.trim());
            int idLibro = Integer.parseInt(inputLibro.trim());

            //creamos la conexión a la base de datos
            Conexion conexion = new Conexion();
            //usamos try  para asegurarnos que se cierre la conexión
            try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM Prestamos WHERE Id_Usuario = ? AND Id_Libro = ?")) {

                // Reemplazamos los signos de ? con los valores del usuario y libro
                stmt.setInt(1, idUsuario);
                stmt.setInt(2, idLibro);
                int filas = stmt.executeUpdate();

                //verificamos si sí se eliminó algo (si el préstamo existía)
                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Devolución realizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un préstamo con esos datos.");
                }
            }

            //si el usuario mete algo que no es número, mostramos un mensaje de error
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Introduce solo números enteros.");
        } catch (SQLException e) {
            //si hubo un error al trabajar se mostrará el error
            JOptionPane.showMessageDialog(null, "Error al realizar devolución: " + e.getMessage());
        }
    }

    //método para registrar un nuevo préstamo
    public void realizarPrestamo() {
        try {
            //le pedimos al usuario que introduzca el ID del usuario
            String inputUsuario = JOptionPane.showInputDialog(null, "Introduce el ID del usuario:");
            if (inputUsuario == null || inputUsuario.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;  // Salimos si no se ingresó el dato
            }

            //solicita el ID del libro
            String inputLibro = JOptionPane.showInputDialog(null, "Introduce el ID del libro:");
            if (inputLibro == null || inputLibro.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            //convertimos las entradas a enteros
            int idUsuario = Integer.parseInt(inputUsuario.trim());
            int idLibro = Integer.parseInt(inputLibro.trim());

            //creamos una instancia de conexión
            Conexion conexion = new Conexion();
            //el query es para inseertar datos nuevos, actualizar algo o eliminar registros.
            // Creamos la conexión y el query INSERT con parámetros
            try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Prestamos (Id_Usuario, Id_Libro, Fecha_Prestamo) VALUES (?, ?, ?)")) {

                //insertamos los valores en el query
                stmt.setInt(1, idUsuario);
                stmt.setInt(2, idLibro);

                //obtenemos la fecha actual para registrar cuándo se hizo el préstamo
                java.sql.Date fechaActual = new java.sql.Date(System.currentTimeMillis());
                stmt.setDate(3, fechaActual); // Se guarda la fecha del préstamo

                //ejecutamos el query de INSERT
                int filas = stmt.executeUpdate();

                //verificamos si sí se insertó (es decir, se registró el préstamo)
                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el préstamo.");
                }
            }

        } catch (NumberFormatException e) {
            //este error saldra por si escribieron letras en vez de números
            JOptionPane.showMessageDialog(null, "ID inválido. Introduce solo números enteros.");
        } catch (SQLException e) {
            //mostramos cualquier error de la bas 
            JOptionPane.showMessageDialog(null, "Error al realizar el préstamo: " + e.getMessage());
        }
    }

}
