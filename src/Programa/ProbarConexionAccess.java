/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Programa;

import Conexiones.Conexion;

/**
 *
 * @author ericr
 */
//esta clasee s ára comprobar medinate la consola si sí sirve o no funciona la conexxion a la basede datos 
public class ProbarConexionAccess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Conexion conexion = new Conexion();//creamos la conexxion 
    if(conexion.estaConectado()) {
        System.out.println("Conexión exitosa!");
    } else {
        System.out.println("Error en la conexión");
    }
    conexion.Desconexion();
    }
    
}
