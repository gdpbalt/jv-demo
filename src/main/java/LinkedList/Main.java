package LinkedList;

public class Main {
  public static void main(String[] args) {
    ListNode node1 = new ListNode(4);
    ListNode node2 = new ListNode(5);
    ListNode node3 = new ListNode(1);
    ListNode node4 = new ListNode(9);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    node2.prev = node1;
    node3.prev = node2;
    node4.prev = node3;

    DoublyLinkedList.deleteNode(node2);
    System.out.println("Ok");
  }
}
