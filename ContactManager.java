import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
private static final ArrayList<Contact> contacts = new ArrayList<>();
private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Contact");
            System.out.println("5. View All Contacts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> editContact();
                case 3 -> deleteContact();
                case 4 -> searchContact();
                case 5 -> viewContacts();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        contacts.add(new Contact(name, phone, email, address));
        System.out.println("Contact added successfully.");
    }

    private static void editContact() {
        viewContacts();
        System.out.print("Enter contact number to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new name: ");
            contacts.get(index).name = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            contacts.get(index).phone = scanner.nextLine();
            System.out.print("Enter new email: ");
            contacts.get(index).email = scanner.nextLine();
            System.out.print("Enter new address: ");
            contacts.get(index).address = scanner.nextLine();
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    private static void deleteContact() {
        viewContacts();
        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    private static void searchContact() {
        System.out.print("Enter name or phone to search: ");
        String keyword = scanner.nextLine();
        for (Contact contact : contacts) {
if (contact.name.contains(keyword) || contact.phone.contains(keyword)) {
                System.out.println(contact);
            }
        }
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("\nYour Contacts:");
            for (int i = 0; i < contacts.size(); i++) {
System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }
}
