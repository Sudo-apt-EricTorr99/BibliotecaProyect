/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import java.util.ArrayList;

/**
 *
 * @author ericr
 */
public class Usuario {

    private String nombre;
    private int IdUsuario;
    private ArrayList<String> librosPrestados;

    public Usuario(String nombre, int IdUsuario) {
        this.nombre = nombre;
        this.IdUsuario = IdUsuario;
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
        return IdUsuario;
    }

    public ArrayList<String> getLibrosPrestados() {
        return librosPrestados;
    }

}
