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
public class MostrarUsuariosDetallados {

    public ArrayList<UsuarioDetallado> obtenerListaUsuarios() {
        ArrayList<UsuarioDetallado> lista = new ArrayList<>();
        Conexion con = new Conexion();

        if (con.estaConectado()) {
            String query = "SELECT id_usuario, nombre, apellido_paterno, apellido_materno, edad, ocupacion FROM Usuario";

            try (Statement stmt = con.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    UsuarioDetallado user = new UsuarioDetallado(
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("apellido_paterno"),
                            rs.getString("apellido_materno"),
                            rs.getInt("edad"),
                            rs.getString("ocupacion")
                    );
                    lista.add(user);
                }
            } catch (SQLException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }

        return lista;
    }

    public DefaultTableModel obtenerModeloUsuariosDetallado() {
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

        return modelo;
    }
}
