package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * MainView class for the Car-Rent system.
 * This class represents the main user interface.
 */
public class MainView extends JFrame {

    private JButton rentButton;          // Button to navigate to Rent Vehicle screen
    private JButton payInstallmentButton; // Button to navigate to Pay Installments screen
    private JButton exitButton;          // Button to exit the application

    /**
     * Constructor to initialize the main view.
     */
    public MainView() {
        // Configuración de la ventana principal
        setTitle("Car-Rent System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño aumentado para un diseño más espacioso
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout());
        setResizable(false);

        // Crear el panel del título con fondo degradado
        JPanel titlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(45, 156, 219); // Azul degradado inicial
                Color color2 = new Color(34, 128, 188); // Azul degradado final
                GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        titlePanel.setPreferredSize(new Dimension(800, 100));
        JLabel titleLabel = new JLabel("Bienvenido al Sistema de Alquiler de Vehículos", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Crear el panel principal con botones
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 30, 30)); // Espaciado entre botones
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(new EmptyBorder(50, 150, 50, 150)); // Márgenes internos

        // Crear botones estilizados
        rentButton = createStyledButton("Alquilar un Vehículo");
        payInstallmentButton = createStyledButton("Pagar Cuotas");
        exitButton = createStyledButton("Salir");
        exitButton.setBackground(new Color(219, 68, 55)); // Color rojo para el botón de salir

        // Agregar botones al panel principal
        mainPanel.add(rentButton);
        mainPanel.add(payInstallmentButton);
        mainPanel.add(exitButton);

        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Método para crear botones estilizados.
     *
     * @param text Texto del botón.
     * @return JButton estilizado.
     */
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(45, 156, 219)); // Color azul
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);

        // Estilizar bordes redondeados
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(button.getBackground().darker(), 2),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        // Agregar efecto hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(button.getBackground().brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(45, 156, 219));
            }
        });

        return button;
    }

    // Getters para botones
    public JButton getRentButton() {
        return rentButton;
    }

    public JButton getPayInstallmentButton() {
        return payInstallmentButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Main method to test the MainView class.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            mainView.setVisible(true);
        });
    }
}
