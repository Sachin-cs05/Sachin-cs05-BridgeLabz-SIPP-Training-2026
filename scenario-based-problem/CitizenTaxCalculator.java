class CitizenTaxCalculator {
    public static void main(String[] args) {
        double[] incomes = {8000, 12000, 18000, 25000, 32000, 47000, 51000, 62000, 15000, 9000};
        double totalTax = 0;

        for (int i = 0; i < incomes.length; i++) {
            double tax = calculateTax(incomes[i]);
            totalTax += tax;
            System.out.println("Citizen " + (i + 1) + " Income: " + incomes[i] + " Tax: " + tax);
        }

        System.out.println("Total Tax Collected: " + totalTax);
    }

    public static double calculateTax(double income) {
        if (income < 10000) {
            return 0;
        } else if (income <= 50000) {
            return income * 0.15;
        } else {
            return income * 0.30;
        }
    }
}
