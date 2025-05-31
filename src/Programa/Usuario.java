/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author ericr
 */
public class Usuario {

    private String nombre;
    private int id_usuario;
    private ArrayList<String> librosPrestados;

    public Usuario(String nombre, int id_usuario) {
        this.nombre = nombre;
        this.id_usuario = id_usuario; // ✅ ahora sí está bien
        this.librosPrestados = new ArrayList<>();
    }

    // Métodos existentes
    public void registrarPrestamo(String libro) {
        librosPrestados.add(libro);
    }

    public void devolverLibro(String libro) {
        librosPrestados.remove(libro);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getIdUsuario() {
        return id_usuario;
    }

    public ArrayList<String> getLibrosPrestados() {
        return librosPrestados;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
