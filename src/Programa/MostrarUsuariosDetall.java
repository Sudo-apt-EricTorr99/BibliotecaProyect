/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import Conexiones.Conexion; // Importa la clase que gestiona la conexión a la base de datos
import java.sql.*; // Para manejar SQL (ResultSet, Statement, SQLException, etc.)
import java.util.ArrayList; // Estructura de datos para guardar objetos UsuarioDetallado
import javax.swing.JOptionPane; // Para mostrar mensajes emergentes
import javax.swing.table.DefaultTableModel; // Para manejar modelos de tablas (JTable)

/**
 *
 * @author ericr
 */
public class MostrarUsuariosDetall {

    // Lista para almacenar todos los usuarios detallados desde la base de datos
    private ArrayList<UsuarioDetallado> listaUsuarios = new ArrayList<>();

    // Este método consulta la base de datos, llena el ArrayList y también llena un modelo de tabla
    public DefaultTableModel obtenerModeloUsuariosDetalladoConEstructura() {
        listaUsuarios.clear();  // Limpiamos la lista para evitar duplicados

        // Definimos las columnas del modelo de tabla
        String[] columnas = {"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Ocupación"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0); // Modelo de tabla con columnas

        Conexion con = new Conexion(); // Creamos instancia de conexión

        if (con.estaConectado()) {
            String query = "SELECT id_usuario, nombre, apellido_paterno, apellido_materno, edad, ocupacion FROM Usuario";

            try (
                    Statement stmt = con.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                // Mientras haya registros, los procesamos
                while (rs.next()) {
                    // Creamos un objeto UsuarioDetallado con los datos del registro actual
                    UsuarioDetallado user = new UsuarioDetallado(
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("apellido_paterno"),
                            rs.getString("apellido_materno"),
                            rs.getInt("edad"),
                            rs.getString("ocupacion")
                    );

                    // Agregamos a la estructura de datos
                    listaUsuarios.add(user);

                    // Agregamos al modelo de la tabla
                    modelo.addRow(new Object[]{
                        user.getId(),
                        user.getNombre(),
                        user.getApellidoPaterno(),
                        user.getApellidoMaterno(),
                        user.getEdad(),
                        user.getOcupacion()
                    });
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos.");
        }

        return modelo;
    }

    // Este método permite obtener la lista de usuarios por separado si se necesita en otra parte
    public ArrayList<UsuarioDetallado> getListaUsuarios() {
        return listaUsuarios;
    }
}
