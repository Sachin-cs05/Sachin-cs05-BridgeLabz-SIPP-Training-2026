import java.util.*;

public class EventEntryVerificationSystem {

    static HashSet<String> participants = new HashSet<>();

    static void registerParticipant(String email) {
        if (participants.add(email)) {
            System.out.println("Registration Successful.");
        } else {
            System.out.println("Duplicate Registration Not Allowed.");
        }
    }

    static void displayParticipants() {
        if (participants.isEmpty()) {
            System.out.println("No Participants Registered.");
            return;
        }

        System.out.println("\n--- Registered Participants ---");
        for (String email : participants) {
            System.out.println(email);
        }

        System.out.println("Total Eligible Attendees: " + participants.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Event Entry Verification System =====");
            System.out.println("1. Register Participant");
            System.out.println("2. Display Participants");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Email ID: ");
                    String email = sc.nextLine();
                    registerParticipant(email);
                    break;

                case 2:
                    displayParticipants();
                    break;

                case 3:
                    System.out.println("Program Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}