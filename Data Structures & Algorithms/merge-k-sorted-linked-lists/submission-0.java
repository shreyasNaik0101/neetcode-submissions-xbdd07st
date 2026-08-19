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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });
        for(ListNode list : lists){
            if(list != null){
                pq.add(list);
            }
            
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            ListNode newNode = new ListNode(smallest.val);
            temp.next = newNode;
            temp = temp.next;

            if(smallest.next != null){
                pq.add(smallest.next);
            }
        }
        return dummy.next;
    }
}
