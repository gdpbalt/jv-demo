package stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamApiMedium {
  private final int YEAR_INDEX = 1;
  private final int AGE_INDEX = 0;

  public static void main(String[] args) {
    StreamApiMedium var = new StreamApiMedium();

    List<String> listString =
        List.of(
            "John Stevenson:2020",
            "Andrew Ferguson:2012",
            "Andrew Ferguson:2012",
            "Andrew Rerguson:2012",
            "Andrew Ferguson:2013");
    System.out.println(var.getVisitorsPerYear(listString, 2012));

    //        Map<String, Integer> map = Map.of(
    //                "MicroSystem", -2000,
    //                "Odyssey", -100,
    //                "Oracle", 50000,
    //                "Destiny", 0,
    //                "Jupiter", 200,
    //                "Infinity", 2000000,
    //                "Clarity", 2000);
    //        System.out.println(var.getCompanies(map));

    //        List<Integer> listInteger = List.of(-533, 121, 44, 11, 27, 450);
    //        System.out.println(var.convertAndModifyNumbers(listInteger));

    //    System.out.println(var.charsIncrementation("ABCD", 1));

    //    List<String> stringList = List.of("99:Johny", "20:Brad", "18:Alice", "47:Dmitry");
    //    System.out.println(var.getOldestPersonAge(stringList));
  }

  /**
   * Given list strings representing records of patients' visits to a Hospital {"John
   * Stevenson:2020", "Andrew Ferguson:2012", "Andrew Ferguson:2013"}. Return number of unique
   * persons who have visited hospital during the given year (second input param). Be careful,
   * because one person may visit a hospital several times per year and for each visit new record
   * will be generated. Result shouldn't contain duplicates.
   */
  public Long getVisitorsPerYear(List<String> records, int year) {
    return records.stream()
        .filter(r -> Integer.parseInt(r.split(":")[YEAR_INDEX]) == year)
        .distinct()
        .count();
  }

  /**
   * Given a map with the following view : "company name" - "monthly income delta" (String/Integer)
   * Return list of the companies with positive delta. Their names should be sorted alphabetically
   * Example input : {"Sun.ltd" : 20_000}, {"Micro" : -5_200}, {"Clarity": 0}, {"Odyssey": 9_640};
   * Output : {"Odyssey", "Sun.ltd"}
   */
  public List<String> getCompanies(Map<String, Integer> input) {
    return input.entrySet().stream()
        .filter(i -> i.getValue() > 0)
        .map(Map.Entry::getKey)
        .sorted()
        .collect(Collectors.toList());
  }

  /**
   * Given a list of integer numbers, convert each integer into its' binary representation in string
   * format and join all of them into a single string and putting each value into brackets, it
   * should look like this: Input: {1, 20, 33} Output: (1) (10100) (100001)
   */
  public String convertAndModifyNumbers(List<Integer> numbers) {
    return numbers.stream()
        .map(Integer::toBinaryString)
        .collect(Collectors.joining(")" + System.lineSeparator() + "(", "(", ")"));
  }

  /**
   * Given string value. Your task is to increment char value of each symbol from the string. Amount
   * to increment is passed with the second input param - 'increment'
   */
  public String charsIncrementation(String string, int increment) {
    return string
        .chars()
        .mapToObj(c -> (char) (c += increment))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  /**
   * Given List of string where each element represents persons' age and name: {"99:Johny",
   * "20:Brad", ...} return the age of the oldest person
   */
  public Long getOldestPersonAge(List<String> peoples) {
    return peoples.stream()
        .map(p -> Long.valueOf(p.split(":")[AGE_INDEX]))
        .max(Long::compareTo)
        .get();
  }
}
