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
        // Edge cases: empty list, single node, or no rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // 1. Calculate the length of the list and find the tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // 2. Connect the tail to the head to form a circle
        tail.next = head;
        
        // 3. Find the actual number of rotations needed
        k = k % length;
        int stepsToNewTail = length - k;
        
        // 4. Move to the node right before the new head (the new tail)
        for (int i = 0; i < stepsToNewTail; i++) {
            tail = tail.next;
        }
        
        // 5. Set the new head and break the circular connection
        head = tail.next;
        tail.next = null;
        
        return head;
    }
}
