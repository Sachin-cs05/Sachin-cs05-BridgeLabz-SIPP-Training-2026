class Drone {
    private String droneId;
    private int batteryPercentage;
    static String companyName = "SkyShip Logistics";

    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        if (batteryPercentage > 20) {
            System.out.println(droneId + " started delivery.");
            batteryPercentage -= 20;
        } else {
            System.out.println(droneId + " cannot start delivery. Battery too low.");
        }
    }

    public void displayStatus() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Drone ID: " + droneId);
        System.out.println("Battery Percentage: " + batteryPercentage + "%");
        System.out.println();
    }
}

public class DroneDeliverySystem {
    public static void main(String[] args) {
        Drone drone1 = new Drone("DR101", 90);

        drone1.startDelivery();

        drone1.displayStatus();
    }
}
