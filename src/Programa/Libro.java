/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

/**
 *
 * @author ericr
 */
//heredamos atributos y metodos desde la clase material  
public class Libro extends Material {

    //constuctor que revibe los datos y los pasa a la superclase Material 
    public Libro(String titulo, String autor, int anioPublicacion) {
        super(titulo, autor, anioPublicacion); // Llama al constructor de la superclase
    }

    //metodo sobreescrito para mostrar los detakkkes dek libro en consola
    //lama al metodo de la superclase para mostarrr los datpos comunes y luego agrega el tipo libro 
    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Tipo: Libro");
    }
}
