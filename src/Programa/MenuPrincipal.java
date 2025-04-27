import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        initComponents();
        setTitle("Menú Principal");
        setSize(400, 300); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
    }

    private void initComponents() {
        // Crear un panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Usar un BorderLayout para organizar los componentes

        // Mensaje de bienvenida
        JLabel mensajeBienvenida = new JLabel("¡Bienvenido al Menú Principal!", SwingConstants.CENTER);
        mensajeBienvenida.setFont(new Font("Arial", Font.BOLD, 18)); // Establecer fuente y tamaño
        panel.add(mensajeBienvenida, BorderLayout.CENTER); // Agregar el mensaje al centro del panel

        // Botón de salir
        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> {
            System.exit(0); // Cerrar la aplicación al hacer clic en "Salir"
        });
        panel.add(salirButton, BorderLayout.SOUTH); // Agregar el botón en la parte inferior

        // Agregar el panel a la ventana
        add(panel);
    }

    public static void main(String[] args) {
        // Mostrar la ventana del menú principal
        SwingUtilities.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true); // Hacer visible la ventana
        });
    }
}