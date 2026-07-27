class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(a.length()!=b.length())return a.length()-b.length();
            return a.compareTo(b);
        });
        for(String num : nums){
            if(pq.size()<k)pq.add(num);
            else if(num.length()>pq.peek().length()){
                pq.poll();
                pq.add(num);
            }else if(num.length()==pq.peek().length() && num.compareTo(pq.peek())>0){
                pq.poll();
                pq.add(num);
            }
        }
        return pq.peek();
    }
}