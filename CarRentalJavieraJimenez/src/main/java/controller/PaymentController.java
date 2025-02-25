package controller;

import model.Rental;
import model.Installment;
import view.InstallmentPaymentView;

import javax.swing.*;
import java.util.List;

public class PaymentController {

    private List<Rental> rentals; // Lista de arriendos del sistema
    private InstallmentPaymentView paymentView;

    public PaymentController(List<Rental> rentals) {
        this.rentals = rentals;
        paymentView = new InstallmentPaymentView();

        // Asignar eventos a los botones
        paymentView.getShowPaymentsButton().addActionListener(e -> showPayments());
        paymentView.getPayButton().addActionListener(e -> payInstallment());
    }

    // Mostrar los pagos del arriendo seleccionado
    private void showPayments() {
        try {
            int selectedRow = paymentView.getRentalTable().getSelectedRow();
            if (selectedRow == -1) {
                throw new IllegalArgumentException("Por favor, seleccione un arriendo.");
            }

            // Cargar cuotas del arriendo seleccionado
            Rental rental = rentals.get(selectedRow);
            List<Installment> installments = rental.getInstallments();

            // Mostrar cuotas en la tabla de pagos
            String[][] data = new String[installments.size()][3];
            for (int i = 0; i < installments.size(); i++) {
                Installment installment = installments.get(i);
                data[i][0] = String.valueOf(installment.getInstallmentNumber());
                data[i][1] = String.format("$%.2f", installment.getAmount());
                data[i][2] = installment.isPaid() ? "Sí" : "No";
            }

            String[] columns = {"Número", "Valor", "Pagada"};
            paymentView.getPaymentTable().setModel(new javax.swing.table.DefaultTableModel(data, columns));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(paymentView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Realizar el pago de una cuota
    private void payInstallment() {
        try {
            int selectedRow = paymentView.getPaymentTable().getSelectedRow();
            if (selectedRow == -1) {
                throw new IllegalArgumentException("Por favor, seleccione una cuota para pagar.");
            }

            int rentalIndex = paymentView.getRentalTable().getSelectedRow();
            Rental rental = rentals.get(rentalIndex);
            Installment installment = rental.getInstallments().get(selectedRow);

            if (installment.isPaid()) {
                throw new IllegalArgumentException("Esta cuota ya está pagada.");
            }

            installment.setPaid(true);
            JOptionPane.showMessageDialog(paymentView, "Cuota pagada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            showPayments(); // Actualizar tabla
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(paymentView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayPaymentView() {
        SwingUtilities.invokeLater(() -> paymentView.setVisible(true));
    }
}
