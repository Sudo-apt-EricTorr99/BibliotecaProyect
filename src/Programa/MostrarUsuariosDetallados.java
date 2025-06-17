/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion; //importa la clase Conexion que contiene la lógica para conectarse a la base de datos
import java.sql.*; //Importa todas las clases de java.sql (Statement, ResultSet, SQLException, etc.)
import java.util.ArrayList; //permite usar listas dinámicas para guardar objetos
import javax.swing.JOptionPane; //permite mostrar mensajes emergentes al usuario
import javax.swing.table.DefaultTableModel;  //permite construir tablas que se pueden mostrar en interfaces gráficas (JTable)

/**
 *
 * @author ericr
 */
//clase que obtiene los datos detallados de los usuarios desde la base de datos y los devuelve como lista o modelo de tabla
public class MostrarUsuariosDetallados {

    public ArrayList<UsuarioDetallado> obtenerListaUsuarios() { //método que devuelve una lista de objetos UsuarioDetallado
        ArrayList<UsuarioDetallado> lista = new ArrayList<>();  //crea una lista vacía para almacenar usuarios
        //creamos una intancia  para conectarse a l abase de datos 
        Conexion con = new Conexion(); 

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
                     //devuelve la lista con los usuarios cargados
                    lista.add(user);
                }
                //si ocurre un error al ejecutar la consulta
            } catch (SQLException ex) {
                System.err.println("Error: " + ex.getMessage());  //imprime el mensaje de error en consola
            }
        }

        return lista; //devuelve la lista 
    }

    //método que devuelve un modelo de tabla con los datos de usuarios
    public DefaultTableModel obtenerModeloUsuariosDetallado() {
        //encavezamos la lista y añade cada usuario co,omo una nueva fila en la tabla 
        String[] columnas = {"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Ocupación"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);  //crea un nuevo modelo de tabla con esas columnas y 0 filas

        for (UsuarioDetallado user : obtenerListaUsuarios()) { //recorre cada usuario de la lista
            modelo.addRow(new Object[]{ //agrega una nueva fila al modelo con los datos del usuario
                user.getId(),
                user.getNombre(),
                user.getApellidoPaterno(),
                user.getApellidoMaterno(),
                user.getEdad(),
                user.getOcupacion()
            });
        }

        return modelo;  //devuelve el modelo listo para usarse en un JTable
    }
}
