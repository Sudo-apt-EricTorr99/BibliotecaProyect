/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion;
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
public class EnlistarRegistrosUsuarios implements MetodosEnlistUsers {

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        Conexion con = new Conexion();
        ArrayList<Usuario> listado = new ArrayList<>();

        if (con.estaConectado()) {
            String query = "SELECT id_usuario AS id, nombre, apellido_paterno, apellido_materno, edad, ocupacion FROM Usuario";

            try (Statement stmt = con.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    Usuario user = new Usuario(
                            rs.getString("nombre"),
                            rs.getInt("id"),
                            rs.getString("apellido_paterno"),
                            rs.getString("apellido_materno"),
                            rs.getInt("edad"),
                            rs.getString("ocupacion")
                    );
                    listado.add(user);
                }

            } catch (SQLException ex) {
                System.err.println("Error en listarUsuarios: " + ex.getMessage());
            }
        }

        return listado;
    }

    public DefaultTableModel llenarTablaUsuarios() {
        try {
            ArrayList<Usuario> usuarios = listarUsuarios();

            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[]{"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Ocupación"}, 0);

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
