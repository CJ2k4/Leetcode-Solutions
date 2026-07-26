class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){
            if(pq.size()<3){
                pq.offer(num);
            }else if(num>pq.peek()){
                pq.poll();
                pq.add(num);
            }

            if(pqMin.size()<2){
                pqMin.offer(num);
            }else if(num<pqMin.peek()){
                pqMin.poll();
                pqMin.offer(num);
            }
        }
        int ans1=1;
        int max = 0;
        while(!pq.isEmpty()){
            ans1*=pq.peek();
            int curr = pq.poll();
            if(pq.isEmpty())max = curr;
        }
        int ans2 = max;
        while(!pqMin.isEmpty()){
            ans2*=pqMin.peek();
            pqMin.poll();
        }
        return Math.max(ans1, ans2);
    }
}