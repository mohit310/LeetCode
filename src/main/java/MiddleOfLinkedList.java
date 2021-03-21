/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * tip is to use the same concept of cyclic linklist. slow and fast pointer. Since we are jumping fast pointer 2 at a time it will reach the end and the slow will be in middle.
 */
public class MiddleOfLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
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
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode six = new ListNode(6, null);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        ListNode head = new ListNode(0, one);
        MiddleOfLinkedList m = new MiddleOfLinkedList();

        System.out.println(m.getMiddle(head));

    }
}
