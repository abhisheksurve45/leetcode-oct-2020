public class SortList {

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

        private ListNode getMiddleNode(ListNode head) {

            ListNode fast = head, slow = head, mid;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            mid = slow.next;
            slow.next = null;
            return mid;
        }


        private ListNode merge(ListNode l1, ListNode l2) {

            ListNode dummy = new ListNode(-1), curr = dummy;

            while (l1 != null && l2 != null) {

                if (l1.val <= l2.val) {

                    curr.next = l1;
                    l1 = l1.next;

                } else {

                    curr.next = l2;
                    l2 = l2.next;

                }

                curr = curr.next;
            }

            curr.next = l1 != null ? l1 : l2;

            return dummy.next;
        }


        public ListNode sortList(ListNode head) {

            if (head == null || head.next == null) return head;

            ListNode middle = getMiddleNode(head);

            ListNode l1 = sortList(head);
            ListNode l2 = sortList(middle);

            return merge(l1, l2);
        }
    }

}
