package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RentalView extends JFrame {

    private JComboBox<String> customerComboBox; // ComboBox para seleccionar cliente
    private JComboBox<String> vehicleComboBox; // ComboBox para seleccionar vehículo
    private JTextField rentalDateField; // Campo para ingresar la fecha de arriendo
    private JTextField rentalDaysField; // Campo para ingresar los días de arriendo
    private JTextField dailyRateField; // Campo para ingresar el precio por día
    private JTextField installmentCountField; // Campo para ingresar la cantidad de cuotas
    private JLabel totalAmountLabel; // Etiqueta para mostrar el monto total
    private JButton calculateButton; // Botón para calcular el monto
    private JButton saveRentalButton; // Botón para guardar el arriendo
    private JButton addCustomerButton; // Botón para agregar un nuevo cliente
    private JTable installmentsTable; // Tabla para mostrar las cuotas generadas

    public RentalView() {
        setTitle("Gestión de Arriendos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout());
        setResizable(false);

        // Panel principal para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 15, 15));
        inputPanel.setBorder(new EmptyBorder(20, 40, 20, 40));

        JLabel customerLabel = new JLabel("Cliente:");
        customerLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        customerComboBox = new JComboBox<>();

        JLabel vehicleLabel = new JLabel("Vehículo:");
        vehicleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        vehicleComboBox = new JComboBox<>();

        JLabel rentalDateLabel = new JLabel("Fecha de arriendo:");
        rentalDateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        rentalDateField = new JTextField();

        JLabel rentalDaysLabel = new JLabel("Días de arriendo:");
        rentalDaysLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        rentalDaysField = new JTextField();

        JLabel dailyRateLabel = new JLabel("Precio por día:");
        dailyRateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        dailyRateField = new JTextField();

        JLabel installmentCountLabel = new JLabel("Cantidad de cuotas:");
        installmentCountLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        installmentCountField = new JTextField();

        inputPanel.add(customerLabel);
        inputPanel.add(customerComboBox);
        inputPanel.add(vehicleLabel);
        inputPanel.add(vehicleComboBox);
        inputPanel.add(rentalDateLabel);
        inputPanel.add(rentalDateField);
        inputPanel.add(rentalDaysLabel);
        inputPanel.add(rentalDaysField);
        inputPanel.add(dailyRateLabel);
        inputPanel.add(dailyRateField);
        inputPanel.add(installmentCountLabel);
        inputPanel.add(installmentCountField);

        add(inputPanel, BorderLayout.WEST);

        // Etiqueta para el monto total
        totalAmountLabel = new JLabel("Monto Total: $0.00", JLabel.CENTER);
        totalAmountLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        totalAmountLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(totalAmountLabel, BorderLayout.NORTH);

        // Tabla para cuotas
        installmentsTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(installmentsTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Cuotas Generadas"));
        tableScrollPane.setPreferredSize(new Dimension(400, 300));
        add(tableScrollPane, BorderLayout.CENTER);

        // Panel para botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        calculateButton = createStyledButton("Calcular Monto", new Color(45, 156, 219));
        saveRentalButton = createStyledButton("Guardar Arriendo", new Color(45, 156, 219));
        addCustomerButton = createStyledButton("Nuevo Cliente", new Color(34, 128, 188));

        buttonPanel.add(calculateButton);
        buttonPanel.add(saveRentalButton);
        buttonPanel.add(addCustomerButton);
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
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    // Getters para los componentes
    public JComboBox<String> getCustomerComboBox() {
        return customerComboBox;
    }

    public JComboBox<String> getVehicleComboBox() {
        return vehicleComboBox;
    }

    public JTextField getRentalDateField() {
        return rentalDateField;
    }

    public JTextField getRentalDaysField() {
        return rentalDaysField;
    }

    public JTextField getDailyRateField() {
        return dailyRateField;
    }

    public JTextField getInstallmentCountField() {
        return installmentCountField;
    }

    public JLabel getTotalAmountLabel() {
        return totalAmountLabel;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JButton getSaveRentalButton() {
        return saveRentalButton;
    }

    public JButton getAddCustomerButton() {
        return addCustomerButton;
    }

    public JTable getInstallmentsTable() {
        return installmentsTable;
    }
}
