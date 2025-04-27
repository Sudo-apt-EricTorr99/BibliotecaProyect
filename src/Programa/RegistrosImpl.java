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

public class RegistrosImpl implements Registros {

    @Override
    public ArrayList<Material> listarLibros() {
        Conexion con = new Conexion();
        ArrayList<Material> listado = new ArrayList<>();
        
         if (con.estaConectado()) {
        // Usamos la tabla Libros y sus campos reales.
        // Year(Fecha_Lanzamiento) extrae sólo el año de la fecha.
        String query = 
          "SELECT Id_Libro AS id, " +
          "       Nombre AS nombre, " +
          "       Year(Fecha_Lanzamiento) AS anio, " +
          "       Id_Editorial AS editorial " +
          "FROM Libros";
        try (Statement stmt = con.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Material mat = new Material();
                mat.setId(       rs.getInt("id") );
                mat.setNombre(   rs.getString("nombre") );
                mat.setAnio(     rs.getInt("anio") );
                mat.setEditorial(rs.getString("editorial") );  // si editorial es numérico, usa getInt
                listado.add(mat);
            }
        } catch (SQLException ex) {
            System.err.println("Error en listarLibros: " + ex.getMessage());
        }
    }
    return listado;
    }

    @Override
    public String darFormato(ArrayList<Material> materiales) {
        StringBuilder sb = new StringBuilder("ID\t|NOMBRE\t|AÑO\t|EDITORIAL\n");
        sb.append("----------------------------------\n");
        
        for (Material mat : materiales) {
            sb.append(mat.getId()).append("\t|")
              .append(mat.getNombre()).append("\t|")
              .append(mat.getAnio()).append("\t|")
              .append(mat.getEditorial()).append("\n");
        }
        return sb.toString();
    }

    // Método que llena el modelo de la tabla con los datos de los libros
    public DefaultTableModel llenarTablaLibros() {
        try {
            ArrayList<Material> libros = listarLibros();  // Obtener los libros desde la base de datos

            DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID", "Nombre", "Año", "Editorial"}, 0);

            for (Material libro : libros) {
                modelo.addRow(new Object[]{
                    libro.getId(),
                    libro.getNombre(),
                    libro.getAnio(),
                    libro.getEditorial()
                });
            }

            return modelo;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
