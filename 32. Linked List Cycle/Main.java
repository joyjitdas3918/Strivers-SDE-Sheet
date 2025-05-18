public class Main {
    public boolean hasCycle(ListNode head) {
        ListNode temp=head;
        int x=0;
        while (temp!=null){
            temp=temp.next;
            if(temp==null) return false;
            temp=temp.next;
            head=head.next;
            if(head==temp) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Main main = new Main();
        // Example usage
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        head.next.next.next.next = head.next; // Creating a cycle

        boolean result = main.hasCycle(head);
        System.out.println(result); // Output: true
    }
}
