/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Programa;

import java.util.ArrayList; //mporta la clase ArrayList para poder usar listas dinámicas

/**
 *
 * @author ericr
 */
public interface MetodosEnlistUsers {

    //metodo que debe devolver una lista de objetos tipo Usuario
    ArrayList<Usuario> listarUsuarios(); 

    //metodo que debe recibir una lista de objetos tipo Material y devolver un String con algún formato
    String darFormato(ArrayList<Material> materiales); 
}
