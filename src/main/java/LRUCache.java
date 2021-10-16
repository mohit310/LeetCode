import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private int count;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    class Node {
        int key, val;
        Node prev;
        Node next;

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }

    }

    public LRUCache(int capacity) {
        if (capacity == 0) capacity = 1;
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = cache.get(key);
        if (n != null) {
            removeNode(n);
            addNode(n);
            return n.val;
        }
        return -1;
    }

    private Node popTail() {
        Node res = tail.prev;
        this.removeNode(res);
        return res;
    }

    private void removeNode(Node n) {
        Node nPrev = n.prev;
        Node nNext = n.next;
        nPrev.next = nNext;
        nNext.prev = nPrev;
    }

    private void addNode(Node n) {
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
    }

    public void put(int key, int val) {
        Node n = cache.get(key);
        if (n != null) {
            n.val = val;
            //Move to Head;
            removeNode(n);
            addNode(n);
        } else {
            n = new Node();
            n.key = key;
            n.val = val;
            cache.put(key, n);
            addNode(n);
            ++count;
            if (count > capacity) {
                Node tail = popTail();
                cache.remove(tail.key);
                --count;
            } else {
                n.val = val;
                removeNode(n);
                addNode(n);
            }

        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}
