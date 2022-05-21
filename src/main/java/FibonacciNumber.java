public class FibonacciNumber {
    public static int getFibonacciNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }
}
