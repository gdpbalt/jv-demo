package LinkedList;

public class DoublyLinkedList {
  public static void insertNode(ListNode previous, ListNode newNode) {
    newNode.prev = previous;
    newNode.next = previous.next;

    previous.next = newNode;
    newNode.next.prev = newNode;
  }

  public static void deleteNode(ListNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
}
