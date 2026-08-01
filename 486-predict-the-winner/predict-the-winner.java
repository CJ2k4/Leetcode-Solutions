class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total+= num;
        }
        dp = new int[n][n];
        for(int[] d : dp ){
            Arrays.fill(d, -1);
        }
        int p1Score= solve(nums, 0, n-1);
        if( p1Score >= total-p1Score)return true;
        return false;
    }
    int[][] dp;
    int solve(int[] nums, int i, int j){
        if(i==j){
            return nums[i]; 
        }
        else if (i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int iScore = nums[i] + Math.min(solve(nums, i+2, j), solve(nums, i+1, j-1));
        int jScore = nums[j] + Math.min(solve(nums, i, j-2), solve(nums, i+1, j-1));
        return dp[i][j]=Math.max(iScore, jScore);   
    }
}