import java.util.*;
public class Main {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hashMap = new HashMap<>();
        Node cur = head;

        while (cur != null) {
            hashMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            Node copy = hashMap.get(cur);
            copy.next = hashMap.get(cur.next);
            copy.random = hashMap.get(cur.random);
            cur = cur.next;
        }

        return hashMap.get(head);        
    }
    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next;
        head.next.random = head;

        Main main = new Main();
        Node copiedHead = main.copyRandomList(head);

        // Print the copied list
        Node current = copiedHead;
        while (current != null) {
            System.out.print("Value: " + current.val);
            if (current.random != null) {
                System.out.print(", Random: " + current.random.val);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            current = current.next;
        }
    }
}
