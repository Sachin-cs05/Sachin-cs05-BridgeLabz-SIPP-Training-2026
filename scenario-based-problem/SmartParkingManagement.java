class Vehicle {
    private String vehicleNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println();
    }
}

public class SmartParkingManagement {
    public static void displayCars(Vehicle[] vehicles) {
        System.out.println("Cars in Parking:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getVehicleType().equalsIgnoreCase("Car")) {
                vehicle.displayDetails();
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {
        System.out.println("Bikes in Parking:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getVehicleType().equalsIgnoreCase("Bike")) {
                vehicle.displayDetails();
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[10];

        vehicles[0] = new Vehicle("UP32AB1010", "Amit", "Car");
        vehicles[1] = new Vehicle("UP32CD2020", "Neha", "Bike");
        vehicles[2] = new Vehicle("UP32EF3030", "Rohit", "Car");
        vehicles[3] = new Vehicle("UP32GH4040", "Simran", "Bike");

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}
