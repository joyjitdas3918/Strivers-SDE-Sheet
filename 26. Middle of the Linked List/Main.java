public class Main {
    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            if(temp==null) break;
            temp=temp.next;
            head=head.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode middleNode = main.middleNode(head);
        
        // Print the middle node
        System.out.println("Middle node value: " + middleNode.val);
    }
}
