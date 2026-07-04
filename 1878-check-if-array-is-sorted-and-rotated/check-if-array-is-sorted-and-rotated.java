class Solution {
    public boolean check(int[] nums) {
        int b = 0;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i] < nums[i-1]){
                b=i;
            }
        }
        for(int i = 1; i<n; i++){
            if(nums[(i + b)%n] < nums[(i+b-1)%n])return false;
        }
        return true;
    }
}