import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name, phone, email, address;

public Contact(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
return "Name: " + name + " | Phone: " + phone + " | Email: " + email + " | Address: " + address;
    }
}
