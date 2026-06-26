package polymorphism;

public class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public double fuelCost(double km) {
        return 0;
    }

    public String getName() {
        return name;
    }
}

class Car extends Vehicle {
    protected double petrolPricePerKm;

    public Car(String name, double petrolPricePerKm) {
        super(name);
        this.petrolPricePerKm = petrolPricePerKm;
    }

    public double fuelCost(double km) {
        return km * petrolPricePerKm;
    }

    public void carInfo() {
        System.out.println(name + " is a car");
    }
}

class Bus extends Vehicle {
    private double dieselPricePerKm;

    public Bus(String name, double dieselPricePerKm) {
        super(name);
        this.dieselPricePerKm = dieselPricePerKm;
    }

    public double fuelCost(double km) {
        return km * dieselPricePerKm;
    }

    public void busInfo() {
        System.out.println(name + " is a bus");
    }
}

class Bike extends Vehicle {
    private double bikePricePerKm;

    public Bike(String name, double bikePricePerKm) {
        super(name);
        this.bikePricePerKm = bikePricePerKm;
    }

    public double fuelCost(double km) {
        return km * bikePricePerKm;
    }

    public void bikeInfo() {
        System.out.println(name + " is a bike");
    }
}

class ElectricCar extends Car {
    private double chargingCostPerKm;

    public ElectricCar(String name, double chargingCostPerKm) {
        super(name, 0);
        this.chargingCostPerKm = chargingCostPerKm;
    }

    public double fuelCost(double km) {
        return km * chargingCostPerKm;
    }
}

class VehicleMain {
    public static void main(String[] args) {
        double km = 20;

        Vehicle[] fleet = {
            new Car("Swift", 8),
            new Bus("Volvo", 15),
            new Bike("Pulsar", 3),
            new ElectricCar("Nexon EV", 2)
        };

        for (Vehicle vehicle : fleet) {
            System.out.println(vehicle.getName() + " fuel cost for " + km + " km = " + vehicle.fuelCost(km));

            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                car.carInfo();
            } else if (vehicle instanceof Bus) {
                Bus bus = (Bus) vehicle;
                bus.busInfo();
            } else if (vehicle instanceof Bike) {
                Bike bike = (Bike) vehicle;
                bike.bikeInfo();
            }

            System.out.println();
        }
    }
}
