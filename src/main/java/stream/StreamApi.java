package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
  public static void main(String[] args) {
    List<Integer> listInteger = List.of(4, 1, 10, 20, 11, 3);
    int[] intArray = listInteger.stream().mapToInt(i -> i).toArray();
    List<String> listString = List.of("Kiev", "London", "Paris", "Kiev");
    StreamApi var = new StreamApi();

    //    System.out.println(var.getOddNumsSum(listInteger));

    System.out.println("ok");
  }

  /**
   * Given a List of Integer numbers, return a sum of odd numbers or 0, if there are no odd numbers
   * in the List.
   */
  public Integer getOddNumsSum(List<Integer> numbers) {
    return numbers.stream().filter(i -> i % 2 == 1).reduce(0, (x, y) -> x + y);
  }

  /** Given a List of Strings, return a number of times the `element` String occurs in the List. */
  public Long calculateOccurrences(List<String> elements, String element) {
    return elements.stream().filter(Objects::nonNull).filter(s -> s.equals(element)).count();
  }

  /** Given a List of Strings, return the Optional of its first element. */
  public Optional<String> getFirstElement(List<String> elements) {
    return elements.stream().findFirst();
  }

  /**
   * Given a arrays of ints, return three smallest numbers as list in sorted manner. For example for
   * input {4, 1, 10, 20, 11, 3} output will be {1, 3, 4};
   */
  public List<Integer> getThreeSmallestNumbers(int[] numbers) {
    return Arrays.stream(numbers).sorted().limit(3).boxed().collect(Collectors.toList());
  }

  /**
   * Given a List of Strings, find the String equal to the passed `element` or throw
   * NoSuchElementException.
   */
  public String findElement(List<String> elements, String element) {
    return elements.stream()
        .filter(Objects::nonNull)
        .filter(e -> e.equals(element))
        .findAny()
        .get();
  }
}
