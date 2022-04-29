import java.math.BigInteger;

public class Factorial {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 38;

    public long factorial(long n) {
        if (n < MIN_VALUE || n > MAX_VALUE) {
            throw new IllegalArgumentException("Input number have to be in range [0, 12]");
        }
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}
