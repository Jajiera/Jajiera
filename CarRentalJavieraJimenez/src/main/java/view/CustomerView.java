package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;

public class CustomerView extends JFrame {

    private JTextField idField; // Campo para ingresar la cédula
    private JTextField nameField; // Campo para ingresar el nombre
    private JCheckBox activeCheckBox; // Checkbox para marcar si el cliente está vigente
    private JButton addCustomerButton; // Botón para agregar el cliente

    public CustomerView() {
        // Configuración de la ventana principal
        setTitle("Gestión de Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout());
        setResizable(false);

        // Colores personalizados
        Color primaryColor = new Color(45, 156, 219); // Azul principal
        Color secondaryColor = new Color(240, 240, 240); // Fondo claro
        Color buttonColor = new Color(34, 128, 188); // Azul más oscuro para el botón

        // Panel principal para los campos de entrada con diseño espacioso
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        inputPanel.setBorder(new EmptyBorder(20, 40, 20, 40)); // Márgenes
        inputPanel.setBackground(secondaryColor);

        JLabel idLabel = new JLabel("Cédula:");
        idLabel.setFont(new Font("Arial", Font.BOLD, 14));
        idLabel.setForeground(primaryColor); // Texto azul
        idField = createRoundedTextField();

        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(primaryColor);
        nameField = createRoundedTextField();

        JLabel activeLabel = new JLabel("Vigente:");
        activeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        activeLabel.setForeground(primaryColor);
        activeCheckBox = new JCheckBox();
        activeCheckBox.setBackground(secondaryColor);

        // Agregar los elementos al panel
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(activeLabel);
        inputPanel.add(activeCheckBox);

        // Panel para el botón con diseño elegante
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(20, 10, 20, 10));
        buttonPanel.setBackground(secondaryColor);

        addCustomerButton = new JButton("Agregar Cliente");
        addCustomerButton.setFont(new Font("Arial", Font.BOLD, 16));
        addCustomerButton.setForeground(Color.WHITE);
        addCustomerButton.setBackground(buttonColor);
        addCustomerButton.setFocusPainted(false);
        addCustomerButton.setPreferredSize(new Dimension(180, 50));
        addCustomerButton.setUI(new MetalButtonUI() {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(buttonColor.darker());
                g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 15, 15);
            }
        });
        addCustomerButton.setBorder(BorderFactory.createEmptyBorder());
        buttonPanel.add(addCustomerButton);

        // Agregar los paneles a la ventana principal
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Fondo general
        getContentPane().setBackground(secondaryColor);
    }

    private JTextField createRoundedTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        textField.setBackground(Color.WHITE);
        return textField;
    }

    // Getters para los componentes
    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JCheckBox getActiveCheckBox() {
        return activeCheckBox;
    }

    public JButton getAddCustomerButton() {
        return addCustomerButton;
    }
}
