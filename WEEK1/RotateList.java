public class RotateList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode rotateRight(ListNode head, int k) {

            if (head == null || head.next == null || k == 0) return head;

            ListNode fast = head, slow = head;

            int size = 1;

            // CALCULATE TOTAL LENGTH
            while (fast.next != null) {
                size++;
                fast = fast.next;
            }

            // CALCULATE THE BREAKPOINT
            for (int j = size - k % size; j > 1; j--) {
                slow = slow.next;
            }

            // ROTATE
            fast.next = head;
            head = slow.next;
            slow.next = null;

            return head;
        }
    }
}
