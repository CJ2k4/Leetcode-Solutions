class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if(k==0)return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        int start = 0;
        for(int i=0; i<n; i++){
            if(freq.getOrDefault(nums[i],0)==k){
                ans = Math.max(ans, i-start);
                while(nums[start]!=nums[i]){
                    if(freq.get(nums[start])==1)freq.remove(nums[start]);
                    else freq.put(nums[start], freq.get(nums[start])-1);
                    start++;
                }
                start++;
            }else{
                freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
            }
        }
        ans = Math.max(ans, n-start);
        return ans;
    }
}