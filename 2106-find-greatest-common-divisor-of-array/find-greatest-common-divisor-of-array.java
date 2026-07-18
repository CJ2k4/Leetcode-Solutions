class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = min;
        for(int i : nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        while(min!=0){
            int temp = min;
            min = max%min;
            max = temp;
        }
        return max;
    }
}