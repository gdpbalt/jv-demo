import java.util.EmptyStackException;

public class Stack<T> {
  private int size;
  private Node<T> head;

  public Stack() {}

  public void push(T value) {
    Node<T> node = new Node<>(value, null);
    if (head != null) {
      node.next = head;
    }
    head = node;
    size++;
  }

  public T peek() {
    if (head == null) {
      throw new EmptyStackException();
    }
    return head.value;
  }

  public T pop() {
    if (head == null) {
      throw new EmptyStackException();
    }
    T oldValue = head.value;
    head = head.next;
    size--;
    return oldValue;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    Node<T> current = head;
    StringBuilder out = new StringBuilder();
    while (current != null) {
      out.append(current.value).append(" ");
      current = current.next;
    }
    return String.format("[%s] (%d)", out.toString().strip(), size);
  }

  private static class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
      this.value = value;
      this.next = next;
    }
  }
}
