/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion; //para conectarse a la base de datos
import java.sql.*; //para ejecutar consultas SQL
import java.util.LinkedList; //estructura de datos para almacenar libros
import javax.swing.JOptionPane; // Para mostrar mensajes al usuario
import javax.swing.table.DefaultTableModel; // Para mostrar los datos en una tabla

/**
 *
 * @author ericr
 */
public class EnlistarLibros {

    //este método obtiene los libros de la base de datos y los guarda en una estructura (LinkedList),
    //además llena un modelo de tabla con esos mismos datos para mostrarlos en una JTable.
    public DefaultTableModel obtenerModeloLibros() {
        Conexion conexion = new Conexion(); // Se conecta a la base de datos
        LinkedList<Libro> listaLibros = new LinkedList<>(); //estructura de datos para almacenar los libros
        DefaultTableModel modelo = new DefaultTableModel(); //modelo de tabla que se va a llenar

        //se agregan las columnas al modelo de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("ID Autor");
        modelo.addColumn("ID Editorial");
        modelo.addColumn("Fecha Lanzamiento");

        String sql = "SELECT Id_Libro, Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento FROM Libros";

        try (
                PreparedStatement ps = conexion.getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("Id_Libro");
                String nombre = rs.getString("Nombre");
                int idAutor = rs.getInt("Id_Autor");
                int idEditorial = rs.getInt("Id_Editorial");
                Date fecha = rs.getDate("Fecha_Lanzamiento");

                //creamos un nuevo objeto Libro con los datos de la fila
                Libro libro = new Libro(id, nombre, idAutor, idEditorial, fecha);

                //agregamos el libro a la estructura de datos
                listaLibros.add(libro);

                //agregamos el libro a la tabla
                modelo.addRow(libro.toFila());
            }

            //si no hay libros registrados, avisamos al usuario
            if (listaLibros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay libros registrados.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener libros: " + e.getMessage());
        }

        return modelo; //devolvemos el modelo para que se pueda mostrar en una JTable
    }
}
