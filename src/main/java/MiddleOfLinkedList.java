/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * tip is to use the same concept of cyclic linklist. slow and fast pointer. Since we are jumping fast pointer 2 at a time it will reach the end and the slow will be in middle.
 */
public class MiddleOfLinkedList {
    static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    //0->1->2->3->4->5->6->null - return 3
    //0->1->2->3->4->5->null - two middle as 2 and 3 since even number of node return 3 and not 2
    public Node getMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        //Node six = new Node(6, null);
        //Node five = new Node(5, six);
        Node five = new Node(5, null);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node one = new Node(1, two);
        Node head = new Node(0, one);
        MiddleOfLinkedList m = new MiddleOfLinkedList();

        System.out.println(m.getMiddle(head));

    }
}
