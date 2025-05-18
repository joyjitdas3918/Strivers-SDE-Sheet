public class Main {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        for(int i=0;i<n;i++) temp=temp.next;
        ListNode del=head;
        if(temp==null) return head.next;
        while(temp.next!=null){
            temp=temp.next;
            del=del.next;
        }
        del.next=del.next.next;
        return head;
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        Main solution = new Main();
        ListNode result = solution.removeNthFromEnd(head, n);
        
        // Print the modified list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
