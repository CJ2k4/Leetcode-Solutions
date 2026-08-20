class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int sum = 0;
        dp = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
            sum += stoneValue[i];
        }
        return solve(stoneValue, 0, n-1, sum);
    }
    int[][] dp ;
    int solve(int[] stoneValue, int i, int j, int totalSum){
        if(i>=j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int sumTillK = 0;
        int ans= 0;
        for(int k = i; k<j; k++){
            sumTillK += stoneValue[k];

            int sumAfterK = totalSum - sumTillK;

            if(sumTillK>sumAfterK){
                ans = Math.max(ans, sumAfterK+solve(stoneValue, k+1, j, sumAfterK));
            }else if(sumTillK<sumAfterK){
                ans = Math.max(ans, sumTillK+solve(stoneValue, i, k, sumTillK));
            }else{
                ans = Math.max(ans,sumTillK+ Math.max(solve(stoneValue, k+1, j, sumAfterK),solve(stoneValue, i, k, sumTillK)));
            }
        }
        return dp[i][j] = ans;
    }
}