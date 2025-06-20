/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import java.sql.Date;
import Programa.Material;

/**
 *
 * @author ericr
 */
//heredamos atributos y metodos desde la clase material  
public class Libro extends Material {

    private int id; // ID del libro
    private int idAutor;
    private int idEditorial;
    private Date fechaLanzamiento;

    // Constructor original que ya usas
    public Libro(String titulo, String autor, int anioPublicacion) {
        super(titulo, autor, anioPublicacion);
    }

    // 👇 Constructor adicional que necesitaremos para cargar desde la base de datos
    public Libro(int id, String nombre, int idAutor, int idEditorial, Date fechaLanzamiento) {
        super(); // llamamos al constructor vacío del padre
        this.id = id;
        this.setNombre(nombre); // usamos setter heredado
        this.idAutor = idAutor;
        this.idEditorial = idEditorial;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    // Método auxiliar para mostrar como texto tipo línea (para la lista en JOptionPane)
    public String toLinea() {
        return "ID: " + id
                + " | Título: " + getNombre()
                + " | ID Autor: " + idAutor
                + " | ID Editorial: " + idEditorial
                + " | Fecha: " + (fechaLanzamiento != null ? fechaLanzamiento.toString() : "N/A");
    }

    // Método para convertir a fila para DefaultTableModel
    public Object[] toFila() {
        return new Object[]{id, getNombre(), idAutor, idEditorial, fechaLanzamiento};
    }

    // Getters por si los necesitas
    public int getId() {
        return id;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }
}
