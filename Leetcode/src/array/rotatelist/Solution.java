package array.rotatelist;

import array.ListNode;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int i = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            i++;
        }
        k = k % i;
        if (k == 0) {
            return head;
        }
        tail.next = head;
        ListNode newtail = head;
        for (int j = 0; j < i - k - 1; j++) {
            newtail = newtail.next;
        }
        ListNode newhead = newtail.next;
        newtail.next = null;
        return newhead;
    }
    
    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Hàm in ListNode ra dạng [1,2,3,...]
    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(",");
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = buildList(arr);

        Solution sol = new Solution();
        ListNode result = sol.rotateRight(head, 2);

        printList(result); // Output: [4,5,1,2,3]
        
        // Input: head = [0,1,2], k = 4
        // Output: [2,0,1]
        int[] arr2 = {0,1,2};
        ListNode head2 = buildList(arr2);
        ListNode result2 = sol.rotateRight(head2, 4);
        printList(result2);
    }

}
