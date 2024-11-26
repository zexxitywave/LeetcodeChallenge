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
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode leftPointer = left;
        ListNode rightPointer = right;

        while(head!= null){
            if(head.val < x){
                leftPointer.next = head;
                leftPointer = leftPointer.next;
            }else{
                rightPointer.next = head;
                rightPointer = rightPointer.next;
            }
            head = head.next;
        }
            
        rightPointer.next = null;

        leftPointer.next = right.next;

        return left.next;
        
    }
}