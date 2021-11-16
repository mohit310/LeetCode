public class AddTwoNumbersLinkedList {

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
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev1 = reverse(l1, null);
        ListNode rev2 = reverse(l2, null);
        ListNode prev = null;
        int carry = 0;
        while (rev1 != null || rev2 != null) {
            int l = (rev1 == null) ? 0 : rev1.val;
            int r = (rev2 == null) ? 0 : rev2.val;
            int sum = l + r + carry;
            ListNode t = new ListNode(sum % 10);
            carry = sum / 10;
            rev1 = rev1 != null ? rev1.next : null;
            rev2 = rev2 != null ? rev2.next : null;
            t.next = prev;
            prev = t;
        }
        if (carry == 1) {
            ListNode t = new ListNode(carry);
            t.next = prev;
            prev = t;
        }
        return prev;
    }

    private static void print(ListNode rev) {
        while (rev != null) {
            System.out.println(rev.val);
            rev = rev.next;
        }
    }

    public static ListNode reverse(ListNode node, ListNode pre) {
        if (node == null) return pre;
        ListNode next = node.next;
        node.next = pre;
        return reverse(next, node);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(0, new ListNode(1)));
        ListNode l2 = new ListNode(9, new ListNode(9));
        print(AddTwoNumbersLinkedList.addTwoNumbers(l1, l2));
    }
}
