class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int n : nums)total+=n;
        int n = nums.length;
        if(total-x < 0)return -1;
        if(total-x == 0)return n;
        int req = total-x;
        int left =0;
        int sum = 0;
        int longest = -1;
        for(int right = 0; right<n; right++){
            sum+=nums[right];
            while(left<=right && sum>req){
                sum-=nums[left++];
            }
            if(sum == req)longest = Math.max(longest, right-left+1);
        }
        if(longest == -1)return -1;
        return n-longest;
    }
}