public class Fibonacci {

    // Method to compute the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, result = 0;

        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }

    // Main method with command-line argument
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Fibonacci <n>");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);

            if (n < 0) {
                System.out.println("Please enter a non-negative integer.");
                return;
            }

            int result = fibonacci(n);
            System.out.println("Fibonacci number at position " + n + " is: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}