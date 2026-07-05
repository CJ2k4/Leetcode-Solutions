class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            while(!q.isEmpty() && q.peek() <= i-k){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]){
                q.pollLast();
            }
            q.add(i);
            if(i>=k-1){
                ans.add(nums[q.peek()]);
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}