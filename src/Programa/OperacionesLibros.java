/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion; //importamos la clase que maneja la conexión con la base de datos
import javax.swing.JOptionPane;  //permite mostrar ventanas emergentes para avisos o errores
import java.sql.Connection;   //permite usar el objeto de conexión
import java.sql.Date; //permite manejar fechas tipo SQL
import java.sql.PreparedStatement; //permite preparar consultas SQL seguras
import java.sql.SQLException; //permite capturar errores relacionados con SQL 

/**
 *
 * @author ericr
 */
//clase que contiene métodos para agregar y eliminar libros en la base de datos 
public class OperacionesLibros {

    //agregamos un libro nuevo a la base de datos  
    public void agregarLibro(String nombre, int idAutor, int idEditorial, Date fechaLanzamiento) {
        Conexion conexion = new Conexion(); //creamos la conexion 
        //consulta SQL con signos de interrogación para  Evita errores al insertar comillas o caracteres raros. 
        String sql = "INSERT INTO Libros (Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            //asigna el valor de cada parámetro en la consulta
            pstmt.setString(1, nombre);
            pstmt.setInt(2, idAutor);
            pstmt.setInt(3, idEditorial);
            pstmt.setDate(4, fechaLanzamiento);

            //ejecuta la consulta INSERT en la base de datos
            pstmt.executeUpdate();
            //muestra un mensaje indicando que se agregó correctamente
            JOptionPane.showMessageDialog(null, "Libro agregado correctamente.");

            //muestra un mensaje de error si algo sale mal al insertar
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar libro: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //método para eliminar un libro de la base de datos por medio de su ID
    public void eliminarLibro() {
        try {
            //le pide al usuario que escriba el ID del libro que quiere eliminar
            String input = JOptionPane.showInputDialog(null, "Introduce el ID del libro a eliminar:", "Eliminar libro", JOptionPane.QUESTION_MESSAGE);

            //si el usuario cancela o no escribe nada, se cancela la operación
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada o sin ID ingresado.");
                return;
            }

            //convierte el texto ingresado a un número entero
            int idLibro = Integer.parseInt(input.trim()); //convierte a un numero   

            Conexion conexion = new Conexion(); //nueva conexión a la base
            try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM Libros WHERE Id_Libro = ?")) {

                //asigna el ID a eliminar en la consulta
                stmt.setInt(1, idLibro);
                //ejecuta la consulta DELETE y guarda cuántas filas se eliminaron
                int filas = stmt.executeUpdate(); //ejecuta el delete 

                //si al menos una fila fue eliminada, el libro fue encontrado y eliminado
                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente.");
                    //si no se encontró ningún libro con ese ID
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ID.");
                }

            }

        } catch (NumberFormatException e) {
            //si el ID ingresado no era un número válido
            JOptionPane.showMessageDialog(null, "ID inválido. Introduce un número entero.");
        } catch (SQLException e) {
            //si ocurre un error al intentar eliminar el libro
            JOptionPane.showMessageDialog(null, "Error al eliminar libro: " + e.getMessage());
        }
    }

}
