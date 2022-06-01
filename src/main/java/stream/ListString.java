package stream;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListString {
  public static void main(String[] args) {
    List<String> cities = List.of("Kiev", "London", "Paris", "Oslo", "Kyoto", "Ottawa");

//    Set<Character> uniqueCharacters = getUniqueCharacters(cities);
//    System.out.println(uniqueCharacters);

    String firstStartWithLetter = getFirstStartWithLetter(cities, 'K');
    System.out.println(firstStartWithLetter);
  }

  public static Set<Character> getUniqueCharacters (List<String> list) {
    return list.stream()
            .map(String::chars)
            .flatMap(IntStream::boxed)
            .mapToInt(i -> i)
            .mapToObj(i -> (char) i)
            .collect(Collectors.toSet());
  }

  public static String getFirstStartWithLetter(List<String> list, char letter) {
    Optional<String> string = list.stream()
            .filter(s -> s.charAt(0) == letter)
            .findAny();
    return string.orElseThrow(() -> new RuntimeException("Can't find the first letter"));
  }
}
