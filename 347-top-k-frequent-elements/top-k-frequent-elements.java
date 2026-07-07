class Solution {
    class Pair implements Comparable<Pair>{
        int num, count;
        Pair(int num, int count){
            this.num = num;
            this.count = count;
        }

        public int compareTo(Pair b){
            return this.count-b.count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key : freq.keySet()){
            pq.add(new Pair(key,freq.get(key)));
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] res = new int[pq.size()];
        int i = 0;
        for(Pair p : pq){
            res[i++]=p.num;
        }
        return res;
    }
}