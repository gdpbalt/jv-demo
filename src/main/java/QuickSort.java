import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static final int MAX_NUMBERS = 50;
    public static final int HIGH_VALUE = 1000;

    public static void main(String[] args) {
        int[] numbers = new int[MAX_NUMBERS];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(HIGH_VALUE);
        }
        System.out.printf("Array before sort: %s\n", Arrays.toString(numbers));

        quicksort(numbers);

        System.out.printf("Array after sort: %s\n", Arrays.toString(numbers));
    }

    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPoint = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPoint - 1);
        quicksort(array, leftPoint + 1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPoint = lowIndex;
        int rightPoint = highIndex;

        while (leftPoint < rightPoint) {
            while(array[leftPoint] <= pivot && leftPoint < rightPoint) {
                leftPoint++;
            }

            while(array[rightPoint] >= pivot && leftPoint < rightPoint) {
                rightPoint--;
            }

            swap(array, leftPoint, rightPoint);
        }
        swap(array, leftPoint, highIndex);
        return leftPoint;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index2];
        array[index2] = array[index1];
        array[index1] = temp;
    }
}
