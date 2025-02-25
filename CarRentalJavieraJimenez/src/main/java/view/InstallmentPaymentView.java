package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InstallmentPaymentView extends JFrame {

    private JComboBox<String> customerComboBox; // ComboBox para seleccionar cliente
    private JTable rentalTable; // Tabla para mostrar los arriendos del cliente
    private JTable paymentTable; // Tabla para mostrar las cuotas del arriendo seleccionado
    private JButton showPaymentsButton; // Botón para mostrar las cuotas del arriendo seleccionado
    private JButton payButton; // Botón para realizar el pago de una cuota

    public InstallmentPaymentView() {
        // Configuración de la ventana
        setTitle("Gestión de Pagos de Cuotas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 500); // Tamaño aumentado para mayor espacio
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout());
        setResizable(false);

        // Colores personalizados
        Color primaryColor = new Color(45, 156, 219);
        Color buttonColor = new Color(34, 128, 188);

        // Panel superior para seleccionar cliente
        JPanel customerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customerPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Márgenes internos
        customerPanel.setBackground(primaryColor);

        JLabel customerLabel = new JLabel("Cliente:");
        customerLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        customerLabel.setForeground(Color.WHITE);

        customerComboBox = new JComboBox<>();
        styleComboBox(customerComboBox);

        customerPanel.add(customerLabel);
        customerPanel.add(customerComboBox);
        add(customerPanel, BorderLayout.NORTH);

        // Panel central para las tablas
        JPanel tablePanel = new JPanel(new GridLayout(1, 2, 20, 20));
        tablePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        tablePanel.setBackground(Color.WHITE);

        // Tabla para arriendos
        rentalTable = new JTable();
        JScrollPane rentalScrollPane = new JScrollPane(rentalTable);
        rentalScrollPane.setBorder(BorderFactory.createTitledBorder("Arriendos del Cliente"));
        tablePanel.add(rentalScrollPane);

        // Tabla para cuotas
        paymentTable = new JTable();
        JScrollPane paymentScrollPane = new JScrollPane(paymentTable);
        paymentScrollPane.setBorder(BorderFactory.createTitledBorder("Cuotas del Arriendo Seleccionado"));
        tablePanel.add(paymentScrollPane);

        add(tablePanel, BorderLayout.CENTER);

        // Panel inferior para botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        buttonPanel.setBackground(Color.WHITE);

        showPaymentsButton = createStyledButton("Mostrar Pagos", buttonColor);
        payButton = createStyledButton("Realizar Pago", buttonColor);

        buttonPanel.add(showPaymentsButton);
        buttonPanel.add(payButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Método para crear botones estilizados.
     *
     * @param text Texto del botón.
     * @param color Color de fondo del botón.
     * @return JButton estilizado.
     */
    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    /**
     * Método para estilizar el ComboBox y hacerlo más grande.
     *
     * @param comboBox JComboBox a estilizar.
     */
    private void styleComboBox(JComboBox<String> comboBox) {
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // Fuente más grande
        comboBox.setPreferredSize(new Dimension(250, 30)); // Ancho y alto aumentado
        comboBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Espaciado interno
        comboBox.setBackground(Color.WHITE); // Fondo blanco
    }

    // Getters para los componentes
    public JComboBox<String> getCustomerComboBox() {
        return customerComboBox;
    }

    public JTable getRentalTable() {
        return rentalTable;
    }

    public JTable getPaymentTable() {
        return paymentTable;
    }

    public JButton getShowPaymentsButton() {
        return showPaymentsButton;
    }

    public JButton getPayButton() {
        return payButton;
    }

    /**
     * Main method to test the InstallmentPaymentView class.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InstallmentPaymentView view = new InstallmentPaymentView();
            view.setVisible(true);
        });
    }
}
