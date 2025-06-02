/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion; //importamos la clase que gestiona la conexion a la base de datos
import java.sql.*; //esto es pára tranajar con SQL 
import java.util.ArrayList;//para guardar el listadoi o de klibro
import javax.swing.JOptionPane; // para que muestre mensaje al usuario
import javax.swing.table.DefaultTableModel; // para mostrar datos en la tabla 

/**
 *
 * @author ericr
 */
public class EnlistarLibros {

    public void listarLibros() {
        Conexion conexion = new Conexion(); //creamos una instancia de la conexion 
        String sql = "SELECT Id_Libro, Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento FROM Libros";
        ArrayList<String> libros = new ArrayList<>(); //lista para guardar cada libro como una linea de texto 

        //abre una conexion ,prepara la sentencia y eh¿jecuta la consulta 
        try (Connection conn = conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            //recorre cada fila de la consulta 
            while (rs.next()) {
                int id = rs.getInt("Id_Libro");
                String nombre = rs.getString("Nombre");
                int idAutor = rs.getInt("Id_Autor");
                int idEditorial = rs.getInt("Id_Editorial");
                Date fecha = rs.getDate("Fecha_Lanzamiento");

                //construye la linea de texto con la informacion del libro 
                String linea = "ID: " + id + " | Título: " + nombre
                        + " | ID Autor: " + idAutor
                        + " | ID Editorial: " + idEditorial
                        + " | Fecha: " + (fecha != null ? fecha.toString() : "N/A");

                libros.add(linea); //agrega la linea a la lista 
            }

            //si no hay librso registrados
            if (libros.isEmpty()) {
                //construimos el mensaje con todos los libros 
                JOptionPane.showMessageDialog(null, "No hay libros registrados.");
            } else {
                StringBuilder mensaje = new StringBuilder("Listado de Libros:\n");
                for (String libro : libros) {
                    mensaje.append(libro).append("\n");
                }
                JOptionPane.showMessageDialog(null, mensaje.toString()); //muestra el mesnaje 
            }

        } catch (SQLException e) {
            //muestra error si falta la consulta 
            JOptionPane.showMessageDialog(null, "Error al listar libros: " + e.getMessage());
        }
    }

    //devuelve un modelo de tabla con todos los lbros para usarlo en el jtable 
    public DefaultTableModel obtenerModeloLibros() {
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();

        //definimos las columnas que tendra la tabla 
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("ID Autor");
        modelo.addColumn("ID Editorial");
        modelo.addColumn("Fecha Lanzamiento");

        String sql = "SELECT Id_Libro, Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento FROM Libros";

        //ejecutamos la consulta 
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            //recorre cada fila del resultado 
            while (rs.next()) {
                Object[] fila = new Object[5]; //creamos un arreglo para la fila
                fila[0] = rs.getInt("Id_Libro");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getInt("Id_Autor");
                fila[3] = rs.getInt("Id_Editorial");
                fila[4] = rs.getDate("Fecha_Lanzamiento");

                modelo.addRow(fila); //agrega la fila al modelo 
            }

        } catch (SQLException e) {
            //imprime el error en la consola si da un error o falla 
            System.out.println("Error al obtener libros: " + e.getMessage());
        }

        return modelo; //devuelve el modelo con los datos cargados  
    }

}
