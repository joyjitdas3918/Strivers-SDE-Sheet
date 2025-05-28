import java.util.*;
public class Main {
    Node head=new Node(0,0), tail=new Node(0,0);
    Map<Integer, Node> map=new HashMap<>();
    int cap;
    public Main(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == cap) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    class Node {
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
    public static void main(String[] args) {
        Main lruCache = new Main(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1, cache is {3=3, 4=4}
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}
