/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private Connection con = null;  // Cambiado a 'con' para consistencia
    private Statement st = null;

    public Conexion() {
        conectar();
    }

    private void conectar() {
        try {
            
            String rutafile = "C:\\Users\\ericr\\OneDrive\\Documents\\NetBeansProjects\\bibliotecaproyect\\DatabaseBiblio2.accdb";
            String Url = "jdbc:ucanaccess://" + rutafile;
            con = DriverManager.getConnection(Url);
            st = con.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 

    public Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                conectar(); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void Desconexion() {
        try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para verificar si la conexión está activa
    public boolean estaConectado() {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException ex) {
            return false;
        }
    }
}
