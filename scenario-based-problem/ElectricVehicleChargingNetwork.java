class ChargingStation {
    static int totalStations = 0;
    static double electricityRate = 12.5;
    private String stationId;
    private double unitsConsumed;

    public ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    public void displayStationDetails() {
        System.out.println("Station ID: " + stationId);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Electricity Rate: " + electricityRate);
        System.out.println("Bill Amount: " + calculateBill());
        System.out.println();
    }
}

public class ElectricVehicleChargingNetwork {
    public static void main(String[] args) {
        ChargingStation station1 = new ChargingStation("ST101", 40);

        station1.displayStationDetails();

        System.out.println("Total Stations: " + ChargingStation.totalStations);

        ChargingStation.electricityRate = 15.0;
        System.out.println();
        System.out.println("After changing electricity rate:");
        station1.displayStationDetails();
    }
}
