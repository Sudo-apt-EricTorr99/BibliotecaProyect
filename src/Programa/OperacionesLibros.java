/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ericr
 */
//clase qon operaciones agregan y eliminan registros desde la base de datos  
public class OperacionesLibros {

    //agregamos un libro nuevo a la base de datos  
    public void agregarLibro(String nombre, int idAutor, int idEditorial, Date fechaLanzamiento) {
        Conexion conexion = new Conexion(); //creamos la conexion 
        //esta es una consulta SQL con placeholders para evitar  una inyeccion jaj
        String sql = "INSERT INTO Libros (Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            //se asignanlos valores al query 
            pstmt.setString(1, nombre);
            pstmt.setInt(2, idAutor);
            pstmt.setInt(3, idEditorial);
            pstmt.setDate(4, fechaLanzamiento);

            //ejecuta el insert 
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Libro agregado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar libro: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo para eliminar libro con su id del libro 
    public void eliminarLibro() {
        try {
            //pedimos id del libro al usuario 
            String input = JOptionPane.showInputDialog(null, "Introduce el ID del libro a eliminar:", "Eliminar libro", JOptionPane.QUESTION_MESSAGE);

            //si no se ingreso nada o cancelo saldra el aviso que fue canlada la operacion
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada o sin ID ingresado.");
                return;
            }

            int idLibro = Integer.parseInt(input.trim()); //convierte a un numero   

            Conexion conexion = new Conexion();
            try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM Libros WHERE Id_Libro = ?")) {

                stmt.setInt(1, idLibro);
                int filas = stmt.executeUpdate(); //ejecuta el delete 

                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ID.");
                }

            }

        } catch (NumberFormatException e) {
            //si no saldra un error 
            JOptionPane.showMessageDialog(null, "ID inválido. Introduce un número entero.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar libro: " + e.getMessage());
        }
    }

}
