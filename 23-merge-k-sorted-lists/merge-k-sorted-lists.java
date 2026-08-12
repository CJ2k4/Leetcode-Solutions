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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode l : lists){
            while(l!=null){
                pq.add(new ListNode(l.val));
                l=l.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr= dummy;
        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
        }
        return dummy.next;
    }
}