public class Main {
    public ListNode reverse(ListNode head,ListNode tail){
        ListNode p=null,c=head,n=head;
        while(c!=tail){
            n=c.next;
            c.next=p;
            p=c;
            c=n;
        }
        return p;
    }
    public int listLength(ListNode head){
        ListNode temp=head;
        int len=0;
        while(temp!=null){
           len++;
           temp=temp.next;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        int n=listLength(head);
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode prevgroupend=dummy;
        ListNode curr=head;

        while(n >= k){
            ListNode grpstart=curr;
            ListNode grpend=curr;
            for(int i=0;i<k;i++){
              grpend=grpend.next;
            }
           
           ListNode newhead=reverse(grpstart,grpend);
           prevgroupend.next=newhead;
           grpstart.next=grpend;

           prevgroupend=grpstart;
           curr=grpend;
           n -=k;
        }
        return dummy.next;

    }
    public static void main(String[] args) {
        Main main = new Main();
        // Example usage
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;

        ListNode result = main.reverseKGroup(head, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
