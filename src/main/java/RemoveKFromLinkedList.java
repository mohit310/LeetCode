import java.util.List;

public class RemoveKFromLinkedList {
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    public static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> head = new ListNode<>(null);
        ListNode<Integer> prev = head;
        ListNode<Integer> curr = l;
        while (curr != null) {
            if(curr.value != k){
                prev.next = curr;
                prev = curr;
            }else{
                prev.next = null;
            }
            curr = curr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        List<Integer> elements = List.of(3, 1, 2, 3, 4, 5);
        var n = RemoveKFromLinkedList.removeKFromList(create(elements), 3);
        print(n);
        elements = List.of(1, 2, 3, 4, 5, 6, 7);
        n = RemoveKFromLinkedList.removeKFromList(create(elements), 10);
        print(n);
        elements = List.of(1000, 1000);
        n = RemoveKFromLinkedList.removeKFromList(create(elements), 1000);
        print(n);


    }

    public static void print(ListNode<Integer> n) {
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
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
