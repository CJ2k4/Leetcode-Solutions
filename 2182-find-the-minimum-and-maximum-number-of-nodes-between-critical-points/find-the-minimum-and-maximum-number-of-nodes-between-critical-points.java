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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        List<Integer> criticalNodes = new ArrayList<>();
        if(head == null || head.next==null || head.next.next == null)return new int[]{-1, -1};
        ListNode prev = head;
        ListNode cur = prev.next;
        ListNode nxt = cur.next;
        int idx = 1;
        while(nxt!=null){
            if(cur.val < prev.val && cur.val<nxt.val )criticalNodes.add(idx);
            else if(cur.val>prev.val && cur.val >nxt.val)criticalNodes.add(idx);
            idx++;
            prev = cur;
            cur = nxt; 
            nxt = nxt.next;
        }
        int n = criticalNodes.size();
        if(n<2)return new int[]{-1,-1};
        int minDist = Integer.MAX_VALUE;
        int maxDist =criticalNodes.get(n-1) - criticalNodes.get(0);
        for(int i =1; i<n ;i++){
            minDist = Math.min(minDist, criticalNodes.get(i)-criticalNodes.get(i-1));
        }
        return new int[]{minDist, maxDist};
    }
}