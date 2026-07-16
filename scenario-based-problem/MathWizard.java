class MathWizard {
    int instanceValue = 100;

    public static void main(String[] args) {
        MathWizard wizard = new MathWizard();

        System.out.println("Is Prime 29: " + wizard.isPrime(29));
        System.out.println("Factorial 5: " + wizard.factorial(5));
        System.out.println("Factorial 5.0: " + wizard.factorial(5.0));
        System.out.println("Fibonacci 8: " + wizard.fibonacci(8));
        System.out.println("GCD of 36 and 24: " + wizard.gcd(36, 24));
        System.out.println("LCM of 12 and 18: " + wizard.lcm(12, 18));
        System.out.println("Absolute Value of -42: " + wizard.abs(-42));
        System.out.println("Power 2^5: " + wizard.power(2, 5));
        wizard.showScopeDifference();
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double factorial(double n) {
        double result = 1;
        for (int i = 2; i <= (int) n; i++) {
            result *= i;
        }
        return result;
    }

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int next = 0;

        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return next;
    }

    public int gcd(int a, int b) {
        a = abs(a);
        b = abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int lcm(int a, int b) {
        return abs(a * b) / gcd(a, b);
    }

    public int abs(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }

    public long power(int base, int exp) {
        long result = 1;
        for (int i = 1; i <= exp; i++) {
            result *= base;
        }
        return result;
    }

    public void showScopeDifference() {
        int instanceValue = 25;
        System.out.println("Local Variable: " + instanceValue);
        System.out.println("Instance Variable: " + this.instanceValue);
    }
}
