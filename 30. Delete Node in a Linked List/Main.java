public class Main {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
    public static void main(String[] args) {
        // Example usage
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        Main main = new Main();
        main.deleteNode(node);

        // Print the modified linked list
        ListNode current = node;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
