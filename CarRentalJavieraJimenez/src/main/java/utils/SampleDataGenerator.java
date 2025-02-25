package utils;

import model.Customer;
import model.Vehicle;
import model.Rental;

import java.util.ArrayList;
import java.util.List;


public class SampleDataGenerator {


    public static List<Customer> generateSampleCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("CUST1", "John Doe", "john.doe@example.com", "+1234567890", true));
        customers.add(new Customer("CUST2", "Jane Smith", "jane.smith@example.com", "+0987654321", true));
        return customers;
    }


    public static List<Vehicle> generateSampleVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("VEH1", "Toyota", "Corolla", 2021, "A", 50.0));
        vehicles.add(new Vehicle("VEH2", "Honda", "Civic", 2020, "A", 55.0));
        return vehicles;
    }


    public static List<Rental> generateSampleRentals() {
        List<Customer> customers = generateSampleCustomers();
        List<Vehicle> vehicles = generateSampleVehicles();
        List<Rental> rentals = new ArrayList<>();

        // Create rentals
        Rental rental1 = new Rental("RNT1", customers.get(0), vehicles.get(0), 5);
        Rental rental2 = new Rental("RNT2", customers.get(1), vehicles.get(1), 3);

        rentals.add(rental1);
        rentals.add(rental2);

        return rentals;
    }
}
