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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode kthNode = findkthNode(temp,k);
            
            if(kthNode == null){
                if(prev != null){
                    prev.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;

            kthNode.next = null;

            reverseList(temp);

            if(temp == head){
                head = kthNode;
            }
            else{
                prev.next = kthNode;
            }

            prev = temp;
            temp = nextNode;



        }

        return head;
    }

    private ListNode findkthNode(ListNode temp , int k){
        k-=1;
        while(temp!= null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
      

        while(curr!= null){
            ListNode nn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nn;
        }

        return prev;
    }
}
