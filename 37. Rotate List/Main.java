public class Main {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        if(head==null) return null;
        for(int i=0;i<k;i++){
            if(temp==null) temp=head;
            temp=temp.next;
        }
        ListNode t=head;
        if(temp==null) return head;
        while(temp.next!=null){
            temp=temp.next;
            t=t.next;
        }
        temp.next=head;
        ListNode ans=t.next;
        t.next=null;
        return ans;
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Main main = new Main();
        ListNode rotatedHead = main.rotateRight(head, 2);

        // Print the rotated list
        ListNode current = rotatedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
