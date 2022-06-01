package stream;

import java.util.Arrays;

public class StringArray {
  public static String[] capitalizeStrings(String[] strings) {
    return Arrays.stream(strings)
        .map(
            s -> {
              if (s == null || s.isEmpty()) {
                return s;
              }
              return s.substring(0, 1).toUpperCase()
                  + (s.length() == 1 ? "" : s.substring(1).toLowerCase());
            })
        .toArray(String[]::new);
  }
}
