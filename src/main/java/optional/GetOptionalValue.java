package optional;

import java.util.Optional;
import java.util.Random;

public class GetOptionalValue {
  public static void main(String[] args) {
    int random = new Random().nextInt(1000);
    GetOptionalValue var = new GetOptionalValue();

    System.out.println(var.getOptionalValue(-11));
  }

  public Integer getOptionalValue(int randomNumber) {
    Optional<Integer> optional = generateRandomOptional(randomNumber);
    return optional.get();
  }

  public Optional<Integer> generateRandomOptional(int randomNumber) {
    return randomNumber % 2 == 0 ? Optional.empty() : Optional.of(randomNumber);
  }
}
