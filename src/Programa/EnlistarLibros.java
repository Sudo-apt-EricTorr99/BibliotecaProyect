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
        Conexion conexion = new Conexion(); //Crea una instancia de tu clase Conexion, para poder conectarte a la base de datos Access. 
        //Defines la consulta SQL que va a sacar los datos de los libros desde la tabla Libros
        String sql = "SELECT Id_Libro, Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento FROM Libros";
        //sSe crea una lista vacía para guardar cada libro como una línea de texto 
        ArrayList<String> libros = new ArrayList<>(); //lista para guardar cada libro como una linea de texto 

        //try con recursos automáticos: se crean tres cosas aquí:
        //conn: conexión a la base de datos.
        //ps: se prepara la consulta.
        //rs: ejecuta la consulta y obtiene los resultados.
        //Si algo falla, pasa directo al catch
        try (Connection conn = conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            //recorre cada fila de la consulta  mientras haya filas en el ResultSet
            while (rs.next()) {
                //Extraes los datos de cada columna de la fila actual: ID, nombre, autor, editorial, y fecha de lanzamiento
                int id = rs.getInt("Id_Libro");
                String nombre = rs.getString("Nombre");
                int idAutor = rs.getInt("Id_Autor");
                int idEditorial = rs.getInt("Id_Editorial");
                Date fecha = rs.getDate("Fecha_Lanzamiento");

                //Aquí se construye una cadena de texto con todos los datos del libro, todo junto y ordenado
                //Se usa el ternario (fecha != null ?) para evitar errores si la fecha es nula (vacía)
                String linea = "ID: " + id + " | Título: " + nombre
                        + " | ID Autor: " + idAutor
                        + " | ID Editorial: " + idEditorial
                        + " | Fecha: " + (fecha != null ? fecha.toString() : "N/A");

                libros.add(linea); //Añade esa línea de texto a la lista libros
            }

            //si la lista quedó vacía (no hay libros vacía osea no hay libros
            if (libros.isEmpty()) {
                //muestra un mensaje diciendo que no hay libros. 
                JOptionPane.showMessageDialog(null, "No hay libros registrados.");
            } else {
                //Si sí hay libros, se arma un mensaje largo usando StringBuilder y se muestra todo de golpe con JOptionPan
                StringBuilder mensaje = new StringBuilder("Listado de Libros:\n");
                for (String libro : libros) {
                    mensaje.append(libro).append("\n");
                }
                JOptionPane.showMessageDialog(null, mensaje.toString()); //muestra el mesnaje 
            }

            //Si ocurre algún error SQL (como que la tabla no exista o haya error en la consulta), entra aquí y muestra el error en una ventana emergente.
        } catch (SQLException e) {
            //muestra error si falta la consulta 
            JOptionPane.showMessageDialog(null, "Error al listar libros: " + e.getMessage());
        }
    }

    //metodo que devuelve un modelo de tabla (DefaultTableModel) con todos los libros para usarlo en un JTable
    public DefaultTableModel obtenerModeloLibros() {
        Conexion conexion = new Conexion(); //Otra vez creamos la conexion
        DefaultTableModel modelo = new DefaultTableModel();//Se crea un nuevo modelo de tabla vacío

        //definimos las columnas que tendra la tabla 
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("ID Autor");
        modelo.addColumn("ID Editorial");
        modelo.addColumn("Fecha Lanzamiento");

        //se usa la misma consulta SQL que antes para traer los libros
        String sql = "SELECT Id_Libro, Nombre, Id_Autor, Id_Editorial, Fecha_Lanzamiento FROM Libros";

        //prepara y ejecuta la consulta.
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            //recorre cada fila del resultado 
            while (rs.next()) {
                 //crea un array de 5 posiciones (una por columna) y mete los datos ahi
                Object[] fila = new Object[5]; //creamos un arreglo para la fila
                fila[0] = rs.getInt("Id_Libro");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getInt("Id_Autor");
                fila[3] = rs.getInt("Id_Editorial");
                fila[4] = rs.getDate("Fecha_Lanzamiento");

                modelo.addRow(fila); //agrega la fila al modelo 
            }

         //si hay error en la consulta
        } catch (SQLException e) {
            //imprime el error en la consola si da un error o falla 
            System.out.println("Error al obtener libros: " + e.getMessage());
        }

        //Devuelve el DefaultTableModel ya con los datos cargados
        return modelo; //devuelve el modelo con los datos cargados  
    }

}
