class Solution {
    int[] preSum;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        preSum = new int[n+1];
        preSum[0]=0;
        for(int i = 1; i<=n ;i++){
            preSum[i] = preSum[i-1]+piles[i-1];
        }
        dp = new int[n+1][2*n+1];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        return solve(piles, 0, 1);

    }

    int[][] dp;

    int solve(int[] piles, int i, int m){
        //he can take up to 
        if(i>=piles.length)return 0;

        if(dp[i][m]!=-1)return dp[i][m];
        int max = 0;
        int remaining = preSum[piles.length] - preSum[i];

        for(int x = 0; x<2*m; x++){
            if(i+x+1>piles.length)break;
            int take = x + 1;
            int temp = Math.max(m, take);

            int opponent = solve(piles, i + take, temp);
            int current = remaining - opponent;

            max = Math.max(max, current);
        }
        return dp[i][m]=max;
    }
}