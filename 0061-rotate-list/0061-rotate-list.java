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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        // Step 1: Find the length of the list
        ListNode current = head;
        int length = 1;  // Start at 1 to count the head node
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        // Step 2: Connect the last node to the head to form a circular list
        current.next = head;
        
        // Step 3: Calculate the new tail position and new head position
        k = k % length;
        int newTailPos = length - k - 1;
        
        ListNode newTail = head;
        for (int i = 0; i < newTailPos; i++) {
            newTail = newTail.next;
        }
        
        // Step 4: Set the new head and break the cycle
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
