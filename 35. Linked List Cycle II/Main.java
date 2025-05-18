public class Main {
    public ListNode detectCycle(ListNode head) {
    ListNode slow=head;
        ListNode fast=head;
        if(head==null) return head;
        while(true){
            if(fast==null) return null;
            slow=slow.next;
            fast=fast.next;
            if(fast==null) return null;
            fast=fast.next;
            if(slow==fast) break;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle

        Main main = new Main();
        ListNode cycleStart = main.detectCycle(head);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
