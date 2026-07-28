class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int f, int s) {
        return Math.max(solve(nums, f, s), solve(nums, s, f));
    }
    int solve(int[] nums, int f, int s){
        int fBlockSum = 0;
        for(int i = 0; i<f; i++){
            fBlockSum+=nums[i];
        }
        int sBlockSum = 0;
        for(int i = f; i<f+s; i++){
            sBlockSum+=nums[i];
        }
        int maxLeftSubSum = fBlockSum;
        int max = maxLeftSubSum+sBlockSum;
        for(int sEnd = f+s; sEnd<nums.length; sEnd++){
            sBlockSum = sBlockSum - nums[sEnd-s] + nums[sEnd];
            fBlockSum = fBlockSum - nums[sEnd-s-f] + nums[sEnd-s];
            maxLeftSubSum = Math.max(maxLeftSubSum, fBlockSum);
            max = Math.max(max, sBlockSum + maxLeftSubSum);
        }
        return max;
    }
}