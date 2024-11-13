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
        
        ListNode current = head;
        int length = 1; 
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
            current.next = head;
        
        k = k % length;
        int newTailPos = length - k - 1;
        
        ListNode newTail = head;
        for (int i = 0; i < newTailPos; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
