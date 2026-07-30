class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int sum =0;
        for(int i = 0; i<n-2; i++){
            for(int j = i+1; j<n-1; j++){
                for(int k = j+1; k<n; k++){
                    if(Math.abs(target-nums[i]-nums[j]-nums[k])<ans){
                        sum=nums[i]+nums[j]+nums[k];
                        ans = Math.abs(target-nums[i]-nums[j]-nums[k]);
                    }
                }
            }
        }
        return sum;
    }
}