package model;

import java.util.ArrayList;


public class Rental {

    private String rentalId;          // Unique identifier for the rental
    private Customer customer;        // Associated customer
    private Vehicle vehicle;          // Associated vehicle
    private int rentalDays;           // Number of days for the rental
    private double totalAmount;       // Total amount for the rental
    private ArrayList<Installment> installments; // List of installments for this rental


    public Rental(String rentalId, Customer customer, Vehicle vehicle, int rentalDays) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.totalAmount = calculateTotalAmount();
        this.installments = new ArrayList<>();
    }

    public String getRentalId() {
        return rentalId;
    }

    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
        this.totalAmount = calculateTotalAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    private double calculateTotalAmount() {
        return rentalDays * vehicle.getDailyRate();
    }

    public ArrayList<Installment> getInstallments() {
        return installments;
    }

    public void generateInstallments(int numberOfInstallments) {
        installments.clear();
        double installmentAmount = totalAmount / numberOfInstallments;

        for (int i = 1; i <= numberOfInstallments; i++) {
            Installment installment = new Installment(i, installmentAmount, false);
            installments.add(installment);
        }
    }

    public boolean evaluateRental() {
        return customer.isActive() && "A".equals(vehicle.getCondition());
    }

    public boolean processRental(int numberOfInstallments) {
        if (!evaluateRental()) {
            return false;
        }

        vehicle.setCondition("R"); // Set vehicle to rented
        generateInstallments(numberOfInstallments);
        return true;
    }
    @Override
    public String toString() {
        return "Rental{" +
                "rentalId='" + rentalId + '\'' +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                ", rentalDays=" + rentalDays +
                ", totalAmount=" + totalAmount +
                ", installments=" + installments +
                '}';
    }
}
