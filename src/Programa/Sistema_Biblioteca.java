package Programa;

import javax.swing.JOptionPane;

public class Sistema_Biblioteca extends javax.swing.JFrame {

    public Sistema_Biblioteca() {
        initComponents();
        setTitle("Sistema Biblioteca");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        logofacultad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TextoUsuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        TextoContraseña = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        Registarnuevousuario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        IngreseElUsuario = new javax.swing.JTextField();
        IngreseContraseña = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logofacultad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/facultad.png"))); // NOI18N
        bg.add(logofacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, -10, 230, 460));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Iniciar Sesión");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 230, 50));

        TextoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoUsuario.setText("Usuario");
        bg.add(TextoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        TextoContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextoContraseña.setText("Contraseña");
        bg.add(TextoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 213, 100, 0));
        bg.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 120, 10));

        Registarnuevousuario.setForeground(new java.awt.Color(51, 51, 51));
        Registarnuevousuario.setText("Registrarme ");
        Registarnuevousuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistarnuevousuarioActionPerformed(evt);
            }
        });
        bg.add(Registarnuevousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        jButton1.setText("Iniciar sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        bg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        IngreseElUsuario.setForeground(new java.awt.Color(102, 102, 102));
        IngreseElUsuario.setText("Ingrese su usuario");
        IngreseElUsuario.setBorder(null);
        bg.add(IngreseElUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        IngreseContraseña.setForeground(new java.awt.Color(102, 102, 102));
        IngreseContraseña.setText("Ingrese su contraseña");
        IngreseContraseña.setBorder(null);
        IngreseContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        IngreseContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngreseContraseñaActionPerformed(evt);
            }
        });
        bg.add(IngreseContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));
        bg.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));
        bg.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 213, 120, 0));
        bg.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 197, -1, -1));
        bg.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngreseContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngreseContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngreseContraseñaActionPerformed

    //boton para iniciar sesion 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Pedir datos al usuario

        // Método para abrir el menú principal

    }//GEN-LAST:event_jButton1ActionPerformed

    //boton para registar nuevo usuario
    private void RegistarnuevousuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistarnuevousuarioActionPerformed

        // Pedir datos al usuario
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del usuario:");
        String correo = JOptionPane.showInputDialog(this, "Ingrese el correo electrónico:");
        String contraseña = JOptionPane.showInputDialog(this, "Ingrese la contraseña:");

        // Verificar que los campos no estén vacíos
        if (nombre != null && correo != null && contraseña != null
            && !nombre.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()) {

            // Aquí podrías guardar los datos en una base de datos o en una lista
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

            // Ejemplo de impresión en consola
            System.out.println("Usuario registrado: " + nombre + " - " + correo);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RegistarnuevousuarioActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema_Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema_Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema_Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema_Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Sistema_Biblioteca().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IngreseContraseña;
    private javax.swing.JTextField IngreseElUsuario;
    private javax.swing.JButton Registarnuevousuario;
    private javax.swing.JLabel TextoContraseña;
    private javax.swing.JLabel TextoUsuario;
    private javax.swing.JPanel bg;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel logofacultad;
    // End of variables declaration//GEN-END:variables
}
