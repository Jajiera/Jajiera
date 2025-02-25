package controller;

import model.Customer;
import model.Rental;
import model.Vehicle;
import view.RentalView;

import javax.swing.*;
import java.util.List;

public class RentalController {

    private List<Customer> customers;
    private List<Vehicle> vehicles;
    private List<Rental> rentals;
    private RentalView rentalView;

    public RentalController(List<Customer> customers, List<Vehicle> vehicles, List<Rental> rentals) {
        this.customers = customers;
        this.vehicles = vehicles;
        this.rentals = rentals;
        rentalView = new RentalView();

        // Agregar listeners a los botones
        rentalView.getCalculateButton().addActionListener(e -> calculateTotalAmount());
        rentalView.getSaveRentalButton().addActionListener(e -> saveRental());
        rentalView.getAddCustomerButton().addActionListener(e -> openCustomerView());
    }

    public void displayRentalView() {
        SwingUtilities.invokeLater(() -> {
            populateCustomerComboBox();
            populateVehicleComboBox();
            rentalView.setVisible(true);
        });
    }

    private void populateCustomerComboBox() {
        JComboBox<String> comboBox = rentalView.getCustomerComboBox();
        comboBox.removeAllItems();
        for (Customer customer : customers) {
            comboBox.addItem(customer.getId() + " - " + customer.getName());
        }
    }

    private void populateVehicleComboBox() {
        JComboBox<String> comboBox = rentalView.getVehicleComboBox();
        comboBox.removeAllItems();
        for (Vehicle vehicle : vehicles) {
            comboBox.addItem(vehicle.getLicensePlate() + " - " + vehicle.getMake() + " " + vehicle.getModel());
        }
    }

    private void calculateTotalAmount() {
        try {
            int rentalDays = Integer.parseInt(rentalView.getRentalDaysField().getText().trim());
            double dailyRate = Double.parseDouble(rentalView.getDailyRateField().getText().trim());
            double totalAmount = rentalDays * dailyRate;
            rentalView.getTotalAmountLabel().setText("Monto Total: $" + String.format("%.2f", totalAmount));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rentalView, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveRental() {
        JOptionPane.showMessageDialog(rentalView, "Función para guardar arriendos aún no implementada.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void openCustomerView() {
        new CustomerController(customers).displayCustomerView();
    }
}
