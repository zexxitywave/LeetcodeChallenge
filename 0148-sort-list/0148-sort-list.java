/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has only one element, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the middle of the linked list using slow and fast pointers
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null; // Split the list into two halves

        // Step 2: Recursively sort the two halves
        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);

        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }

    // Helper method to find the middle of the linked list
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper method to merge two sorted lists
    private ListNode merge(ListNode left, ListNode right) {
        // Create a new dummy node to build the sorted list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the two lists while both are non-empty
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Append the remaining elements from either left or right
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        // Return the merged list starting from the next of the dummy node
        return dummy.next;
    }
}
