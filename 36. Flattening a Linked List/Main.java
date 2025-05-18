public class Main {
    public static Node merge(Node list1, Node list2) {
        // Create a dummy node as a
        // placeholder for the result
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        // Merge the lists based on data values
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            } else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }

        // Connect the remaining
        // elements if any
        if (list1 != null) {
            res.bottom = list1;
        } else {
            res.bottom = list2;
        }

        // Break the last node's
        // link to prevent cycles
        if (dummyNode.bottom != null) {
            dummyNode.bottom.next = null;
        }

        return dummyNode.bottom;
    }

    // Flattens a linked list with bottom pointers
    public static Node flatten(Node head) {
        // If head is null or there
        // is no next node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten the
        // rest of the linked list
        Node mergedHead = flatten(head.next);
        head = merge(head, mergedHead);
        return head;
    }
    public static void main(String[] args) {
        // Example usage
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.bottom = new Node(20);
        head.next.next = new Node(30);
        head.next.bottom.bottom = new Node(40);

        Node flattenedList = flatten(head);
        while (flattenedList != null) {
            System.out.print(flattenedList.data + " ");
            flattenedList = flattenedList.bottom;
        }
    }
}