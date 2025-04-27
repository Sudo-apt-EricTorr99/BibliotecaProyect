/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

/**
 *
 * @author eric
 */
public class Revista extends Material {

    public Revista(String titulo, String autor, int anioPublicacion) {
        super(titulo, autor, anioPublicacion);
    }

    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Libro");
    }
}
