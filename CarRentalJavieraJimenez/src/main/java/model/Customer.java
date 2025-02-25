package model;
import java.util.regex.Pattern;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private boolean isActive;

    public Customer(String id, String name, String email, String phoneNumber, boolean isActive) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Mail Inválido.");
        }
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Teléfono Inválido.");
        }
        this.phoneNumber = phoneNumber;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.+]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\+?[0-9]{10,15}$";
        return Pattern.matches(phoneRegex, phoneNumber);
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isActive=" + isActive +
                '}';
    }

}