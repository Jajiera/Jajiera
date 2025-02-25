package controller;

import model.Customer;
import view.CustomerView;

import javax.swing.*;
import java.util.List;

/**
 * Controller for managing customers.
 */
public class CustomerController {

    private List<Customer> customers;
    private CustomerView customerView;

    public CustomerController(List<Customer> customers) {
        this.customers = customers;
        customerView = new CustomerView();

        // Add action listener to the button
        customerView.getAddCustomerButton().addActionListener(e -> addCustomer());
    }

    public void displayCustomerView() {
        SwingUtilities.invokeLater(() -> customerView.setVisible(true));
    }

    private void addCustomer() {
        try {
            String id = customerView.getIdField().getText().trim();
            String name = customerView.getNameField().getText().trim();
            boolean isActive = customerView.getActiveCheckBox().isSelected();

            if (id.isEmpty() || name.isEmpty()) {
                throw new IllegalArgumentException("Todos los campos son obligatorios.");
            }

            Customer customer = new Customer(id, name, "", "", isActive);
            customers.add(customer);

            JOptionPane.showMessageDialog(customerView, "Cliente agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            customerView.dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(customerView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
