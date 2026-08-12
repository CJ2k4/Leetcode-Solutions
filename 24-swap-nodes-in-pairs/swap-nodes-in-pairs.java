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
    public ListNode swapPairs(ListNode head) {
        ListNode a = head;
        if(head!=null && head.next!=null)head = head.next;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(a!=null && a.next != null){
            ListNode b = a.next;
            a.next = b.next;
            b.next = a;
            prev.next = b;

            prev = a;
            a=a.next;
        }
        return head;
    }
}