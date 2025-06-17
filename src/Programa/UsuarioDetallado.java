/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

/**
 *
 * @author ericr
 */
// Esta clase sirve para representar un usuario con todos sus datos.
public class UsuarioDetallado {

    // Atributos privados (encapsulamiento)
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private String ocupacion;

    // Constructor con todos los datos
    public UsuarioDetallado(int id, String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.ocupacion = ocupacion;
    }

    // Getters para acceder a los datos (no hay setters porque es de solo lectura en este caso)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }
}
