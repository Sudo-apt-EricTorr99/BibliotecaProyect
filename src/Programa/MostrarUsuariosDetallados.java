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

/**
 *
 * @author ericr
 */
//obtener los datos detallados de loios usuarios desde la base de datos y se devuelve co,o unalista para mostarr en la tabla 
public class MostrarUsuariosDetallados {

    public ArrayList<UsuarioDetallado> obtenerListaUsuarios() {
        ArrayList<UsuarioDetallado> lista = new ArrayList<>();
        Conexion con = new Conexion(); //creamos la conexion 

        if (con.estaConectado()) //verifica si la conexion este activa  
        {
            String query = "SELECT id_usuario, nombre, apellido_paterno, apellido_materno, edad, ocupacion FROM Usuario";

            //se crea un statement 
            try (Statement stmt = con.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {

                //recorremos cada fila del resultado 
                while (rs.next()) {
                    //se crea un nuevo objepto con los datos de la fila actual 
                    UsuarioDetallado user = new UsuarioDetallado(
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("apellido_paterno"),
                            rs.getString("apellido_materno"),
                            rs.getInt("edad"),
                            rs.getString("ocupacion")
                    );
                    //se agrega a la lista 
                    lista.add(user);
                }
            } catch (SQLException ex) {
                System.err.println("Error: " + ex.getMessage()); //si algo falla aparecera un error 
            }
        }

        return lista; //devuelve la lista 
    }

    //este modelo utiliza lalista de usuarios y la tranforma en unmodelo de tabla  
    public DefaultTableModel obtenerModeloUsuariosDetallado() {
        //encavezamos la lista y añade cada usuario co,omo una nueva fila en la tabla 
        String[] columnas = {"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Ocupación"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (UsuarioDetallado user : obtenerListaUsuarios()) {
            modelo.addRow(new Object[]{
                user.getId(),
                user.getNombre(),
                user.getApellidoPaterno(),
                user.getApellidoMaterno(),
                user.getEdad(),
                user.getOcupacion()
            });
        }

        return modelo; //devuelve el modelo ya listo para usarse en una Jtable  
    }
}
