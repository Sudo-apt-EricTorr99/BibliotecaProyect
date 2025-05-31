/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;
import java.sql.*;

/**
 *
 * @author ericr
 */
public class Libro extends Material {

    public Libro(String titulo, String autor, int anioPublicacion) {
        super(titulo, autor, anioPublicacion); // Llama al constructor de la superclase
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Libro");
    }
}
