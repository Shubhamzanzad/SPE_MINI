import java.util.Scanner;

public class scientificCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Scientific Calculator");
        while (running) {
            System.out.println("1. Square root function (sqrt)");
            System.out.println("2. Factorial function (x!)");
            System.out.println("3. Natural logarithm (ln)");
            System.out.println("4. Power function (x^y)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            double num, result;
            switch (choice) {
                case 1:
                    System.out.print("Enter a number to find its square root: ");
                    num = scanner.nextDouble();
                    if (num < 0) {
                        System.out.println("Cannot calculate square root of a negative number.");
                    } else {
                        result = Math.sqrt(num);
                        System.out.println("Square root of " + num + " is " + result);
                    }
                    break;
                case 2:
                    System.out.print("Enter a number to find its factorial: ");
                    num = scanner.nextDouble();
                    if (num < 0) {
                        System.out.println("Factorial is not defined for negative numbers.");
                    } else {
                        result = factorial((int) num);
                        System.out.println("Factorial of " + num + " is " + result);
                    }
                    break;
                case 3:
                    System.out.print("Enter a number to find its natural logarithm: ");
                    num = scanner.nextDouble();
                    if (num <= 0) {
                        System.out.println("Natural logarithm is not defined for non-positive numbers.");
                    } else if (num == 1) {
                        System.out.println("Natural logarithm of " + num + " is 0");
                    } else {
                        result = Math.log(num);
                        System.out.println("Natural logarithm of " + num + " is " + result);
                    }
                    break;
                case 4:
                    System.out.print("Enter the base: ");
                    num = scanner.nextDouble();
                    System.out.print("Enter the exponent: ");
                    double exponent = scanner.nextDouble();
                    result = Math.pow(num, exponent);
                    System.out.println(num + " raised to the power of " + exponent + " is " + result);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

        System.out.println("Exiting the calculator...");
        scanner.close();
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
