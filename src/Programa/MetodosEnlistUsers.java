/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Programa;

import java.util.ArrayList;

/**
 *
 * @author ericr
 */
public interface MetodosEnlistUsers {

    ArrayList<Usuario> listarUsuarios(); // Porque devuelves usuarios, no materiales

    String darFormato(ArrayList<Material> materiales); // Este lo puedes dejar por ahora
}
