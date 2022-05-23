public class Round {
    public static double round(double number, double scale) {
        scale = Math.pow(10, scale);
        return Math.round(number * scale) / scale;
    }
}
