
package model;

public class Vehicle {

    private String licensePlate; // Unique identifier for the vehicle
    private String make;          // Manufacturer of the vehicle
    private String model;         // Model of the vehicle
    private int year;             // Year of manufacture
    private String condition;     // Current condition of the vehicle (e.g., "A" for available, "R" for rented, "D" for under maintenance)
    private double dailyRate;

    public Vehicle(String licensePlate, String make, String model, int year, String condition, double dailyRate) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
        setCondition(condition);
        setDailyRate(dailyRate);
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        if (!condition.matches("[ARD]")) {
            throw new IllegalArgumentException("Condición Inválida. Debe ser 'A', 'R', or 'D'.");
        }
        this.condition = condition;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate <= 0) {
            throw new IllegalArgumentException("Rango Diario debe ser mayor a cero");
        }
        this.dailyRate = dailyRate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", condition='" + condition + '\'' +
                ", dailyRate=" + dailyRate +
                '}';
    }
}