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
    ListNode reverseNode(ListNode head){
        ListNode dummy = null;
        ListNode prev = dummy;
        while(head != null){
            ListNode q = head.next;
            head.next = prev;
            prev = head;
            head = q;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow;
        slow = reverseNode(p);
        ListNode q = head;
        while(slow != null){
            if(q.val != slow.val){
                return false;
            }
            q = q.next;
            slow = slow.next;
        }
        return true;
        
    }
}
