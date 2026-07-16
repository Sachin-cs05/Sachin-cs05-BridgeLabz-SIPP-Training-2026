class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayVehicle() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(model + " is charging.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void refuel() {
        System.out.println(model + " is refueling.");
    }
}

public class VehicleManagementDemo {
    public static void main(String[] args) {
        ElectricVehicle electricVehicle = new ElectricVehicle("Tesla Model 3", 225);
        PetrolVehicle petrolVehicle = new PetrolVehicle("Honda City", 180);

        electricVehicle.displayVehicle();
        electricVehicle.charge();

        System.out.println();

        petrolVehicle.displayVehicle();
        petrolVehicle.refuel();
    }
}
