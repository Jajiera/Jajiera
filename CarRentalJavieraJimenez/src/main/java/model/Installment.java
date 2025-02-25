package model;


public class Installment {

    private int installmentNumber; // Installment number (e.g., 1, 2, 3...)
    private double amount;         // Amount to be paid in the installment
    private boolean isPaid;        // Status of the installment (true if paid, false otherwise)


    public Installment(int installmentNumber, double amount, boolean isPaid) {
        this.installmentNumber = installmentNumber;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("La Entrega debe ser mayor a cero");
        }
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "installmentNumber=" + installmentNumber +
                ", amount=" + amount +
                ", isPaid=" + isPaid +
                '}';
    }
}
