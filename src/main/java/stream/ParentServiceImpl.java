package stream;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParentServiceImpl {
  public List<String> getFatherList() {
    return Storage.getParents().values().stream()
        .flatMap(Collection::stream)
        .filter(p -> p.getSex().equals("male"))
        .map(Parent::getName)
        .distinct()
        .collect(Collectors.toList());
  }
}
