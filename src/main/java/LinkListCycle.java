/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Move twoJump pointer 2 at a time. this way we ensure that if it's a loop, eventuaally one jump will catch on and at some point oneJummp == twoJump
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode oneJump = head, twoJump = head;
        while (twoJump != null && twoJump.next != null) {
            oneJump = oneJump.next;
            twoJump = twoJump.next.next;
            if (oneJump == twoJump) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = head;

        LinkListCycle c = new LinkListCycle();
        //true
        System.out.println(c.hasCycle(head));
        //false
        four.next = null;
        System.out.println(c.hasCycle(head));
    }
}
