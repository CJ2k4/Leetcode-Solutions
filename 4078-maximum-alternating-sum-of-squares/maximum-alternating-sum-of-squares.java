class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int k = (n+1)/2;
        long total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            if(i<0)i*=-1;
            if(pq.size()<k){
                pq.add(i);
            }else if(pq.peek()<i){
                pq.poll();
                pq.add(i);
            }
            total+=(i*i);
        }
        long sum = 0;
        while(pq.size()!=0){
            int i = pq.poll();
            sum+=i*i;
        }
        return 2*sum-total;
    }
}