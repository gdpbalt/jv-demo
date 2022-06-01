package stream;

import java.util.Arrays;

public class Matrix {
  public static void main(String[] args) {
    int[][] matrix = new int[][] {{3, 4}, {1, 2}, {1, 2}, {5, 6}, {7, 8}};
    System.out.println(Arrays.stream(matrix)
            .flatMapToInt(Arrays::stream)
            .distinct()
            .sum());
  }
}
