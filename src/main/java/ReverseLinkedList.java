/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2]
 * Output: [2,1]
 * <p>
 * 1->2->3
 * 1
 * 2-1
 * 3->2->1
 * 1->2->3->4->5
 * 5->4->3->2->1
 */
public class ReverseLinkedList {
    static class Node {
        int val;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public Node reverse(Node n) {
        return reverseList(n, null);
    }

    public Node reverseList(Node node, Node pre) {
        if (node == null) return pre;
        Node next = node.next;
        node.next = pre;
        return reverseList(next, node);

    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n5.val = 5;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ReverseLinkedList r = new ReverseLinkedList();
        Node rev = r.reverse(n1);
        rev = r.reverse(n1);
        print(rev);
    }

    private static void print(Node rev) {
        while (rev != null) {
            System.out.println(rev.val);
            rev = rev.next;
        }
    }
}
