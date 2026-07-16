import java.util.Scanner;

public class UnitConvertorTemperatureWeightVolume {
    public static double convertFarhenheitToCelsius(double farhenheit) {
        return (farhenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        double farhenheit = input.nextDouble();

        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();

        System.out.print("Enter weight in pounds: ");
        double pounds = input.nextDouble();

        System.out.print("Enter weight in kilograms: ");
        double kilograms = input.nextDouble();

        System.out.print("Enter volume in gallons: ");
        double gallons = input.nextDouble();

        System.out.print("Enter volume in liters: ");
        double liters = input.nextDouble();

        System.out.println("Fahrenheit to Celsius: " + convertFarhenheitToCelsius(farhenheit));
        System.out.println("Celsius to Fahrenheit: " + convertCelsiusToFarhenheit(celsius));
        System.out.println("Pounds to kilograms: " + convertPoundsToKilograms(pounds));
        System.out.println("Kilograms to pounds: " + convertKilogramsToPounds(kilograms));
        System.out.println("Gallons to liters: " + convertGallonsToLiters(gallons));
        System.out.println("Liters to gallons: " + convertLitersToGallons(liters));

        input.close();
    }
}
