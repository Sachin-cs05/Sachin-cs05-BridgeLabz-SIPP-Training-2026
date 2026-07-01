import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name : " + name +
               ", Phone : " + phone +
               ", Email : " + email;
    }
}

public class AddressBook {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static HashMap<String, Contact> contactMap = new HashMap<>();
    static HashSet<String> phoneSet = new HashSet<>();

    static void addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number not allowed.");
            return;
        }

        Contact c = new Contact(name, phone, email);
        contacts.add(c);
        contactMap.put(name, c);
        phoneSet.add(phone);

        System.out.println("Contact Added Successfully.");
    }

    static void searchContact(String name) {
        Contact c = contactMap.get(name);

        if (c != null) {
            System.out.println(c);
        } else {
            System.out.println("Contact Not Found.");
        }
    }

    static void deleteContact(String name) {
        Contact c = contactMap.get(name);

        if (c == null) {
            System.out.println("Contact Not Found.");
            return;
        }

        contacts.remove(c);
        contactMap.remove(name);
        phoneSet.remove(c.phone);

        System.out.println("Contact Deleted Successfully.");
    }

    static void displayContacts() {
        Collections.sort(contacts, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c1.name.compareToIgnoreCase(c2.name);
            }
        });

        if (contacts.isEmpty()) {
            System.out.println("No Contacts Available.");
            return;
        }

        System.out.println("\n--- Contact List (Sorted by Name) ---");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n===== Address Book =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    addContact(name, phone, email);
                    break;

                case 2:
                    System.out.print("Enter Name to Search: ");
                    name = sc.nextLine();
                    searchContact(name);
                    break;

                case 3:
                    System.out.print("Enter Name to Delete: ");
                    name = sc.nextLine();
                    deleteContact(name);
                    break;

                case 4:
                    displayContacts();
                    break;

                case 5:
                    System.out.println("Program Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}