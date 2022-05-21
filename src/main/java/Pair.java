import java.util.Objects;

@SuppressWarnings("unchecked") // do not remove this line
public class Pair<K, V> {
  private final K key;
  private final V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pair<K, V> pair = (Pair<K, V>) o;
    return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
  }

  @Override
  public int hashCode() {
    int result = 7;
    result = 31 * result + (key != null ? key.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }
}
