import java.util.Arrays;

public class LevenshteinUse {
  private final String[] words;

  public LevenshteinUse(String[] words) {
    this.words = words;
  }

  public static void main(String[] args) {
    LevenshteinUse fruits =
        new LevenshteinUse(
            new String[] {"strawberry", "cherry", "pineapple", "melon", "raspberry"});
    System.out.println(fruits.findMostSimilar("strawbery")); // -> "strawberry"
    System.out.println(fruits.findMostSimilar("berry")); // -> "cherry"
  }

  public String findMostSimilar(String term) {
    if (term == null || words == null || words.length == 0) {
      throw new RuntimeException("Some of input parameters have null value");
    }
    int minNumber = Integer.MAX_VALUE;
    String minValue = null;
    for (String word : words) {
      int result = Levenshtein.calculate(term, word);
      if (result < minNumber) {
        minNumber = result;
        minValue = word;
      }
    }
    return minValue;
  }
}

class Levenshtein {
  static int calculate(String x, String y) {
    if (x.isEmpty()) {
      return y.length();
    }
    if (y.isEmpty()) {
      return x.length();
    }
    int substitution =
        calculate(x.substring(1), y.substring(1)) + costOfSubstitution(x.charAt(0), y.charAt(0));
    int insertion = calculate(x, y.substring(1)) + 1;
    int deletion = calculate(x.substring(1), y) + 1;
    return min(substitution, insertion, deletion);
  }

  public static int costOfSubstitution(char a, char b) {
    return a == b ? 0 : 1;
  }

  public static int min(int... numbers) {
    return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
  }
}
