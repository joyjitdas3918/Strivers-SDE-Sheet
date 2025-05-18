public class Main {
    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkedList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseLinkedList(slow.next);
        ListNode first = head;
        ListNode second = newHead;
        while (second != null) {
            if (first.val != second.val) {
                reverseLinkedList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLinkedList(newHead);
        return true;
    }   
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Main main = new Main();
        boolean result = main.isPalindrome(head);
        System.out.println(result); // Output: true
    }
}
