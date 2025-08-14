package org.easy.MergeSortedLinkedList;

public class CreateList {

    public static ListNode addNumbers(int [] nums) {
        ListNode newHead = new ListNode(nums[0]);
        ListNode current = newHead;

        for (int i = 1; i < nums.length; i++){
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return newHead;
    }

    static void printList(ListNode curr) {
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null)
                System.out.print(" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int [] numbs = new int[]{1,3,5,7,9,10,15};

        ListNode res = addNumbers(numbs);
        printList(res);
    }
}
