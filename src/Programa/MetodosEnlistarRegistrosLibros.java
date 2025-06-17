/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Programa;

import java.util.ArrayList;

//Si una clase quiere usar esta interfaz, está obligada a tener estos métodos escritos
public interface MetodosEnlistarRegistrosLibros {

    public ArrayList<Usuario> listarUsuarios();

    public String darFormato(ArrayList<Material> materiales); 
}