/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion; //importamos la clase que gestiona la conexion a la base de datos
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ericr
 */
//implementamos los metoo¿dos paera enlistar desde la base de datos y mostrar en la tabla 
public class EnlistarRegistrosUsuarios implements MetodosEnlistUsers {

    //metodo que consulta todos los usuarios registardos en la base de datos 
    //retorna un arraylist de objeptos tipo usuario 
    @Override
    public ArrayList<Usuario> listarUsuarios() {
        Conexion con = new Conexion(); //crea una instancia a la base de datos 
        ArrayList<Usuario> listado = new ArrayList<>(); //lista donde se guardan los usuarios 

        //verificamos si la conexion a la BD fue exitosa
        if (con.estaConectado()) {
            //consulta SQL parea obetener los datos de la tabla de mi base Usuario
            String query = "SELECT id_usuario AS id, nombre, apellido_paterno, apellido_materno, edad, ocupacion FROM Usuario";

            //ejecuta la consulta utilizando statement 
            try (Statement stmt = con.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {

                //recorremos cada fila del resultado 
                while (rs.next()) {
                    //creamos ubn objepto Uusario con los datos de la fila
                    Usuario user = new Usuario(
                            rs.getString("nombre"),
                            rs.getInt("id"),
                            rs.getString("apellido_paterno"),
                            rs.getString("apellido_materno"),
                            rs.getInt("edad"),
                            rs.getString("ocupacion")
                    );
                    //agregamos el usuario a la lista 
                    listado.add(user);
                }

            } catch (SQLException ex) {
                //muestra el error sia lgo falla durante la consulta 
                System.err.println("Error en listarUsuarios: " + ex.getMessage());
            }
        }

        //devuelve la lista de usuarios 
        return listado;
    }

    //metodo para llenar undefault con los datps de los usuarios 
    public DefaultTableModel llenarTablaUsuarios() {
        try {
            //obtenemos la lista de usuarios desde la base de datos 
            ArrayList<Usuario> usuarios = listarUsuarios();

            //creamos el modelo de la tabla con las columnas necesarias 
            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[]{"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Ocupación"}, 0);

            //agrega cada usuario cada fila al modelo de la tabla 
            for (Usuario user : usuarios) {
                modelo.addRow(new Object[]{
                    //user.getIdUsuario(),
                    user.getNombre(),
                    user.getApellidoPaterno(),
                    user.getApellidoMaterno(),
                    user.getEdad(),
                    user.getOcupacion()
                });
            }

            return modelo;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public String darFormato(ArrayList<Material> materiales) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
