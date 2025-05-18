public class Main {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp=new ListNode(0);
        ListNode head=temp;
        int c=0;
        while(l1!=null || l2!=null){
            int a=0,b=0;
            if(l1!=null){
                a=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                b=l2.val;
                l2=l2.next;
            }
            a+=b;
            a+=c;
            c=a/10;
            a%=10;
            temp.val=a;
            temp.next=null;
            ListNode tt=new ListNode(0);
            if(l1!=null || l2!=null || c>0){
                temp.next=tt;
            temp=tt;
            temp.val=c;
            }
            
        }
        return head;
    }
    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Main main = new Main();
        ListNode result = main.addTwoNumbers(l1, l2);
        
        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
