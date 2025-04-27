/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import java.time.LocalDate;

/**
 *
 * @author ericr
 */
public class Prestamo {

    private String libro;
    private Usuario usuario;
    private LocalDate fechaDePrestamo;

    public Prestamo(String libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaDePrestamo = LocalDate.now();
    }
    
    //metodo detalles del prestamo
    public void detallesPrestamo() {
        System.out.println("Libro: " + libro);
        System.out.println("Usuario: " + usuario.getNombre() + " (ID: " + usuario.getIdUsuario() + ")");
        System.out.println("Fecha de préstamo: " + fechaDePrestamo);
    }
}
