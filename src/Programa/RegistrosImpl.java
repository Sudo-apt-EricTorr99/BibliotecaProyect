/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion; //importamos la clase para conectar a la base de datos
//importamos todas las clases necesarias de SQL
import java.sql.*;
//permite usar listas
import java.util.ArrayList;

//permite mostrar mensajes emergentes
import javax.swing.JOptionPane;
//permite crear modelos de tabla para JTables
import javax.swing.table.DefaultTableModel;
//implementa los métodos definidos en la interfaz MetodosEnlistarRegistrosLibros

public class RegistrosImpl implements MetodosEnlistarRegistrosLibros {
    //método para obtener todos los libros guardados en la base de datos

    public ArrayList<Material> listarLibros() {
        Conexion con = new Conexion(); //creamos una conexión nueva
        ArrayList<Material> listado = new ArrayList<>(); //lista donde se guardan los libros

        //verificamos si la conexión a la base de datos está activa
        if (con.estaConectado()) {
            //consulta SQL para traer los campos necesarios desde la tabla Libros
            //extraemos solo el año usando la función YEAR en SQL
            String query
                    = "SELECT Id_Libro AS id, "
                    + "       Nombre AS nombre, "
                    + "       Year(Fecha_Lanzamiento) AS anio, "
                    + "       Id_Editorial AS editorial "
                    + "FROM Libros";
            //ejecutamos la consulta
            try (Statement stmt = con.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {

                //recorremos los resultados de la consulta
                while (rs.next()) {
                    Material mat = new Material();
                    mat.setId(rs.getInt("id"));
                    mat.setNombre(rs.getString("nombre"));
                    mat.setAnio(rs.getInt("anio"));
                    mat.setEditorial(rs.getString("editorial"));  // si editorial es numérico, usa getInt
                    listado.add(mat); //agregamos el material a la lista
                }
                //si algo falla con la consulta, mostramos el error en consola
            } catch (SQLException ex) {
                System.err.println("Error en listarLibros: " + ex.getMessage());
            }
        }
        //retornamos la lista completa de libros
        return listado;
    }

    //método que recibe una lista de materiales y los convierte a texto formateado
    @Override
    public String darFormato(ArrayList<Material> materiales) {
        //usamos StringBuilder para armar el texto
        StringBuilder sb = new StringBuilder("ID\t|NOMBRE\t|AÑO\t|EDITORIAL\n");
        sb.append("----------------------------------\n");

        //recorremos la lista y armamos cada línea del texto
        for (Material mat : materiales) {
            sb.append(mat.getId()).append("\t|")
                    .append(mat.getNombre()).append("\t|")
                    .append(mat.getAnio()).append("\t|")
                    .append(mat.getEditorial()).append("\n");
        }
        //retornamos el texto final
        return sb.toString();
    }

    //método que llena el modelo de la tabla con los datos de los libros
    public DefaultTableModel llenarTablaLibros() {
        try {
            //obtenemos los libros desde la base
            ArrayList<Material> libros = listarLibros();  // Obtener los libros desde la base de datos

            //creamos el modelo de la tabla con las columnas que queremos
            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[]{"ID", "Nombre", "Año", "Editorial"}, 0);

            //agregamos fila por fila los datos al modelo
            for (Material libro : libros) {
                modelo.addRow(new Object[]{
                    libro.getId(),
                    libro.getNombre(),
                    libro.getAnio(),
                    libro.getEditorial()
                });
            }

            //devolvemos el modelo ya lleno
            return modelo;
            //si algo falla mostramos un error con JOptionPane
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
