/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    void insertCopyInBetween(Node head){
        Node temp = head;
        while(temp != null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        } 

    }
    void connectRandomptr(Node head){
        Node temp = head;
        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }
            else{
                copyNode.random = null;
            }
            temp = temp.next.next;

        }
    }
    Node getDeepCopy(Node head){
        Node temp = head;
        Node dnode = new Node(-1);
        Node res = dnode;
        while(temp != null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dnode.next;
    }
    public Node copyRandomList(Node head) {
        insertCopyInBetween(head);
        connectRandomptr(head);
        return getDeepCopy(head);
    }
}
