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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size =0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        if(size == n) return head.next;
        temp = head;
        ListNode prev = head;
        for(int i=0; i<size-n; i++){
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
        temp.next = null;
        return head;
    }
}
