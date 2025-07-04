/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;
//importamos nuestra clase de conexión

import Conexiones.Conexion;
//librerías necesarias para trabajar con SQL y listas
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ericr
 */
//Esta clase representa a un usuario de la biblioteca
// Puede agregarse, eliminarse y registrar préstamos de libros.
public class Usuario {

    //atributos del usuario
    private String nombre;
    private int id_usuario;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private String ocupacion;
    private ArrayList<String> librosPrestados; //lista con los libros que tiene prestados

    //constructor para cuando solo tenemos nombre e ID (como cuando recién se crea)
    public Usuario(String nombre, int id_usuario) {
        this.nombre = nombre;
        this.id_usuario = id_usuario;
        this.librosPrestados = new ArrayList<>();
    }

    ///constructor completo, cuando se recuperan todos los datos desde la base de datos
    public Usuario(String nombre, int id_usuario, String apellidoPaterno, String apellidoMaterno, int edad, String ocupacion) {
        this.nombre = nombre;
        this.id_usuario = id_usuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.librosPrestados = new ArrayList<>();
    }

    // metodo para agregar un nuevo usuario a la base de datos
    public static Usuario agregarUsuario(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String ocupacion) {
        Conexion conexion = new Conexion();
        Usuario nuevoUsuario = null;

        if (nombre.isEmpty() || apellidoPaterno.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre y apellido paterno son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {  //consulta para insertar usuario
            String sql = "INSERT INTO Usuario (nombre, apellido_paterno, apellido_materno, edad, ocupacion) "
                    + "VALUES (?, ?, ?, ?, ?)";

            //usamos RETURN_GENERATED_KEYS para obtener el ID creado
            try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, nombre);
                ps.setString(2, apellidoPaterno);
                ps.setString(3, apellidoMaterno);
                ps.setObject(4, edad.isEmpty() ? null : Integer.valueOf(edad), Types.INTEGER);  //si edad está vacía, mandamos null. Si no, lo convertimos a número
                ps.setString(5, ocupacion.isEmpty() ? null : ocupacion);

                int filas = ps.executeUpdate();

                if (filas > 0) {
                    //si se insertó, obtenemos el ID generado
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        int nuevoId = rs.getInt(1);
                        JOptionPane.showMessageDialog(null, "Usuario agregado con ID: " + nuevoId);
                        //creamos el objeto con el ID
                        nuevoUsuario = new Usuario(nombre, nuevoId);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario agregado, pero no se pudo obtener el ID.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario.");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar usuario: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Edad debe ser un número válido.");
        }

        //retorna el usuario ya creado (o null si falló)
        return nuevoUsuario;
    }

    //metodo para eliminar usuario
    public static void eliminarUsuarioPorId() {
        Conexion conexion = new Conexion();
        try { //pedimos al usuario que ingrese el ID
            String input = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario que desea eliminar:", "Eliminar Usuario", JOptionPane.QUESTION_MESSAGE);

            //si no puso nada o canceló
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada o entrada vacía.");
                return;
            }

            //convertimos el input a número
            int idUsuario = Integer.parseInt(input.trim());

            //consulta para borrar
            String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
            try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
                ps.setInt(1, idUsuario);
                int filas = ps.executeUpdate();

                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con ese ID.");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Debe ser un número entero.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
        }
    }

    //agrega un libro a la lista de préstamos
    public void registrarPrestamo(String libro) {
        librosPrestados.add(libro);
    }

    //remueve un libro de la lista
    public void devolverLibro(String libro) {
        librosPrestados.remove(libro);
    }
    //setter y getter 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public ArrayList<String> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(ArrayList<String> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    String getIdUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
