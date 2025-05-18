public class Main {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tA=headA;
        ListNode tB=headB;
        int a=0,b=0;
        while(tA!=null){
            a++;
            tA=tA.next;
        }
        while(tB!=null){
            b++;
            tB=tB.next;
        }
        tA=headA;
        tB=headB;
        if(a<=b){
            int d=b-a;
            for(int i=0;i<d;i++) tB=tB.next;
        }
        else{
            int d=a-b;
            for(int i=0;i<d;i++) tA=tA.next;
        }
        while(tA!=null && tB!=null){
            if(tA==tB) return tA;
            tA=tA.next;
            tB=tB.next;
        }
        return null;
    }
    public static void main(String[] args) {
        Main main = new Main();
        // Example usage
        ListNode headA = new ListNode(2, new ListNode(4, new ListNode(5)));
        ListNode headB = new ListNode(2);
        ListNode intersection = new ListNode(8, new ListNode(4, new ListNode(5)));
        headA.next = intersection;
        headB.next = intersection;

        ListNode result = main.getIntersectionNode(headA, headB);
        System.out.println(result != null ? result.val : "No intersection");
    }
}
