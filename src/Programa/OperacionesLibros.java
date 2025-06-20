/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion; // maneja la conexión a BD
import javax.swing.JOptionPane;  // para ventanas emergentes
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;  // para usar listas dinámicas

/**
 *
 * @author ericr
 */
//clase que contiene métodos para agregar y eliminar libros en la base de datos 
public class OperacionesLibros {
    // Lista interna para almacenar temporalmente los libros agregados

    private ArrayList<Libro> listaLibros = new ArrayList<>();

    //agregamos un libro nuevo a la base de datos  
    public void agregarLibro(String nombre, int idAutor, int idEditorial, Date fechaLanzamiento) {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO Libros (Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setInt(2, idAutor);
            pstmt.setInt(3, idEditorial);
            pstmt.setDate(4, fechaLanzamiento);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Libro agregado correctamente.");

            // Además de agregar a la BD, creamos un objeto Libro y lo guardamos en la lista interna
            Libro nuevoLibro = new Libro(nombre, "", 0); // usa constructor que tienes, con datos mínimos
            // Aquí puedes crear un constructor más completo si quieres con idAutor, editorial, etc.
            nuevoLibro.setNombre(nombre);  // usa setter para nombre
            nuevoLibro.setEditorial("Editorial con ID: " + idEditorial);  // solo ejemplo
            listaLibros.add(nuevoLibro); // agregamos a la lista

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar libro: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //método para eliminar un libro de la base de datos por medio de su ID
    public void eliminarLibro() {
        try {
            String input = JOptionPane.showInputDialog(null, "Introduce el ID del libro a eliminar:", "Eliminar libro", JOptionPane.QUESTION_MESSAGE);

            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada o sin ID ingresado.");
                return;
            }

            int idLibro = Integer.parseInt(input.trim());

            Conexion conexion = new Conexion();
            try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM Libros WHERE Id_Libro = ?")) {
                stmt.setInt(1, idLibro);
                int filas = stmt.executeUpdate();

                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente.");

                    // También eliminamos el libro de la lista interna, buscando por nombre o id si tuvieras
                    listaLibros.removeIf(libro -> libro.getId() == idLibro);

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un libro con ese ID.");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Introduce un número entero.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar libro: " + e.getMessage());
        }
    }

    // Método adicional para obtener la lista interna (por si quieres usarla en interfaz o debug)
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }
}
