package controller;

import model.Customer;
import model.Rental;
import model.Vehicle;
import utils.SampleDataGenerator;
import view.CustomerView;
import view.InstallmentPaymentView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MainController {

    private RentalController rentalController; // Instancia reutilizable del controlador de arriendos

    public MainController() {
        // Inicializar el controlador de arriendos con datos de ejemplo
        List<Customer> customers = SampleDataGenerator.generateSampleCustomers();
        List<Vehicle> vehicles = SampleDataGenerator.generateSampleVehicles();
        List<Rental> rentals = SampleDataGenerator.generateSampleRentals();
        rentalController = new RentalController(customers, vehicles, rentals);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainController().launchMainMenu();
        });
    }

    public void launchMainMenu() {
        // Crear la ventana principal
        JFrame frame = new JFrame("Car-Rent System - Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Panel principal con diseño y márgenes
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240));

        // Panel para el título
        JPanel titlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color gradientStart = new Color(45, 156, 219);
                Color gradientEnd = new Color(34, 128, 188);
                GradientPaint gradient = new GradientPaint(0, 0, gradientStart, getWidth(), getHeight(), gradientEnd);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        titlePanel.setPreferredSize(new Dimension(600, 80));
        titlePanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Car-Rent System", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 15, 15));
        buttonPanel.setBorder(new EmptyBorder(20, 100, 20, 100));
        buttonPanel.setBackground(new Color(240, 240, 240));

        // Crear botones estilizados
        JButton customerButton = createStyledButton("Gestión de Clientes", e -> openCustomerView());
        JButton rentalButton = createStyledButton("Arriendo con Cuotas", e -> openRentalView());
        JButton paymentButton = createStyledButton("Pago de Cuotas", e -> openInstallmentPaymentView());
        JButton exitButton = createStyledButton("Salir", e -> System.exit(0));

        // Agregar botones al panel
        buttonPanel.add(customerButton);
        buttonPanel.add(rentalButton);
        buttonPanel.add(paymentButton);
        buttonPanel.add(exitButton);

        // Agregar paneles a la ventana
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        frame.add(mainPanel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    private JButton createStyledButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(45, 156, 219));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(button.getBackground().brighter());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(45, 156, 219));
            }
        });

        button.addActionListener(actionListener);
        return button;
    }

    private void openCustomerView() {
        SwingUtilities.invokeLater(() -> {
            CustomerView customerView = new CustomerView();
            customerView.setVisible(true);
        });
    }

    private void openRentalView() {
        SwingUtilities.invokeLater(() -> {
            rentalController.displayRentalView(); // Reutilizar el RentalController
        });
    }

    private void openInstallmentPaymentView() {
        SwingUtilities.invokeLater(() -> {
            InstallmentPaymentView paymentView = new InstallmentPaymentView();
            paymentView.setVisible(true);
        });
    }
}
