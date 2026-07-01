import java.util.*;

public class SmartParkingSlotManager {

    static ArrayList<String> parkingSlots = new ArrayList<>();

    static void addVehicle(String vehicleNo) {
        if (parkingSlots.contains(vehicleNo)) {
            System.out.println("Vehicle is already parked.");
        } else {
            parkingSlots.add(vehicleNo);
            System.out.println("Vehicle Entered Successfully.");
        }
    }

    static void removeVehicle(String vehicleNo) {
        if (parkingSlots.remove(vehicleNo)) {
            System.out.println("Vehicle Exited Successfully.");
        } else {
            System.out.println("Vehicle Not Found.");
        }
    }

    static void searchVehicle(String vehicleNo) {
        if (parkingSlots.contains(vehicleNo)) {
            System.out.println("Vehicle is currently parked.");
        } else {
            System.out.println("Vehicle is not parked.");
        }
    }

    static void displayVehicles() {
        if (parkingSlots.isEmpty()) {
            System.out.println("Parking Area is Empty.");
            return;
        }

        System.out.println("\n--- Parked Vehicles ---");
        for (String vehicle : parkingSlots) {
            System.out.println(vehicle);
        }

        System.out.println("Total Occupied Parking Slots: " + parkingSlots.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Smart Parking Slot Manager =====");
            System.out.println("1. Vehicle Entry");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display Parked Vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Registration Number: ");
                    String vehicleNo = sc.nextLine();
                    addVehicle(vehicleNo);
                    break;

                case 2:
                    System.out.print("Enter Vehicle Registration Number: ");
                    vehicleNo = sc.nextLine();
                    removeVehicle(vehicleNo);
                    break;

                case 3:
                    System.out.print("Enter Vehicle Registration Number: ");
                    vehicleNo = sc.nextLine();
                    searchVehicle(vehicleNo);
                    break;

                case 4:
                    displayVehicles();
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