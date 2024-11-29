import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Phone Book Application ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Retrieve Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.put(name, phoneNumber);
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Name to Retrieve: ");
                    String searchName = scanner.nextLine();
                    if (phoneBook.containsKey(searchName)) {
                        System.out.println("Phone Number: " + phoneBook.get(searchName));
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Name to Delete: ");
                    String deleteName = scanner.nextLine();
                    if (phoneBook.remove(deleteName) != null) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- All Contacts ---");
                    if (phoneBook.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        for (String key : phoneBook.keySet()) {
                            System.out.println("Name: " + key + ", Phone: " + phoneBook.get(key));
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Phone Book. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
