class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(pq.size() >= k){
                if(!pq.isEmpty() && num < pq.peek())continue;
                pq.poll();
            }
            pq.add(num);
        }
        return pq.peek();
    }
}