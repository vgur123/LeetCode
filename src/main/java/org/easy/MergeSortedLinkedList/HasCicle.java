package org.easy.MergeSortedLinkedList;

public class HasCicle {

    public static boolean isCicle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle possible with 0 or 1 node
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle found

    }


    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 3-> 4-> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // Create a loop
        head.next.next.next.next.next = head.next;


        boolean res = isCicle(head);
        System.out.println(res);
    }
}
