class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for(int i = 1; i<n; i++){
            prefixSum[i] = prefixSum[i-1]+stones[i];
        }
        // Alice = maximize Math.abs(2*score - total)
        dp = new Integer[n];
        return solve(prefixSum, 1, n);
    }

    Integer[] dp ;

    int solve(int[] prefixSum, int i, int n){
        if(i==n-1)return prefixSum[n-1];
        if(dp[i]!=null)return dp[i];
        int take = prefixSum[i] - solve(prefixSum,i+1, n);
        int skip = solve(prefixSum, i+1, n);

        return dp[i] = Math.max(take, skip);
    }
}