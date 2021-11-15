import java.util.List;

public class SingleLinkedListPalindrome {
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    static boolean isListPalindrome(ListNode<Integer> l) {
        ListNode<Integer> fast = l;
        ListNode<Integer> slow = l;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode<Integer> reversed = reverseList(slow, null);
        ListNode<Integer> currFirstHalf = l;
        ListNode<Integer> currSecondHalf = reversed;
        while (currSecondHalf != null) {
            if (currFirstHalf.value.intValue() != currSecondHalf.value.intValue()) return false;
            currFirstHalf = currFirstHalf.next;
            currSecondHalf = currSecondHalf.next;
        }
        return true;
    }

    public static ListNode<Integer> reverseList(ListNode<Integer> node, ListNode<Integer> pre) {
        if (node == null) return pre;
        ListNode<Integer> next = node.next;
        node.next = pre;
        return reverseList(next, node);
    }

    public static void main(String[] args) {
        List<Integer> elements = List.of(0, 1, 0);
        var n = SingleLinkedListPalindrome.isListPalindrome(create(elements));
        System.out.println(n);
        elements = List.of(1, 1000000000, -1000000000, -1000000000, 1000000000, 1);
        n = SingleLinkedListPalindrome.isListPalindrome(create(elements));
        System.out.println(n);
    }

    public static ListNode<Integer> create(List<Integer> elements) {
        ListNode<Integer> head = new ListNode<>(null);
        ListNode<Integer> prev = head;
        ListNode<Integer> curr;
        for (int x : elements) {
            curr = new ListNode<>(x);
            prev.next = curr;
            prev = curr;
        }
        return head.next;
    }
}
