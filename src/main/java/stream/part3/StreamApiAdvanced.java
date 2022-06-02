package stream.part3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiAdvanced {
  private static final int AGE_LIMIT = 18;
  private static final int CAT_LIMIT = 0;

  /**
   * Given array of numbers, your task is to sort them in the reverse order and return only those
   * numbers that can be divided by 5 without a remainder.
   */
  public List<Integer> filterAndReverse(int[] inputNumbers) {
    return Arrays.stream(inputNumbers)
        .filter(x -> x % 5 == 0)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
  }

  /**
   * We want to gather some statistics: we have list of people, and we want to know distribution
   * among the age of women who have cats and are older than 18. Result should have the following
   * view: Map.of(19 - List.of(person1, person2, ...), 21 - List.of(person3, person7, ...);
   */
  public Map<Integer, List<Person>> groupByAge(List<Person> people) {
    Predicate<Person> personPredicate =
        person -> {
          if (person.getSex().equals(Person.Sex.WOMAN)
              && person.getAge() >= AGE_LIMIT
              && person.getCatList().size() > CAT_LIMIT) {
            return true;
          }
          return false;
        };
    return people.stream().filter(personPredicate).collect(Collectors.groupingBy(Person::getAge));
  }

  /**
   * Given a list of random strings, group all of them by the last letter from the string. If last
   * char is a number or punctuation - skip the word.
   */
  public Map<Character, List<String>> groupWordsByLastChar(List<String> words) {
    return words.stream()
        .filter(s -> Character.isLetter(s.charAt(s.length() - 1)))
        .collect(Collectors.groupingBy(s -> s.charAt(s.length() - 1)));
  }
}
