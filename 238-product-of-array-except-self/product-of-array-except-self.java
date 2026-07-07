class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int z=0;
        for(int num : nums){
            if(num!=0)product*=num;
            else z++;
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0 && z>1)ans[i]=0;
            else if(nums[i]==0)ans[i]=product;
            else if(z>=1)ans[i]=0;
            else ans[i] = product/nums[i];
        }
        return ans;
    }
}