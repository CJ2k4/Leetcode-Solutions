class Solution {
    public boolean stoneGame(int[] piles) {
        // dp = new int[piles.length][piles.length];
        // for(int[] d : dp){
        //     Arrays.fill(d, -1);
        // }
        // int alice = solve(piles, 0,piles.length-1);
        // int sum = Arrays.stream(piles).reduce(0,(a,b)->a+b);
        // return (alice > sum-alice);
        return true;
    }
    int[][] dp;
    int solve(int[] piles, int i, int j){
        if(i==j)return piles[i];
        else if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int iPiles = piles[i]+Math.min(solve(piles, i+2, j) ,solve(piles,i+1, j-1));
        int jPiles = piles[j]+Math.min(solve(piles, i, j-2) ,solve(piles,i+1, j-1));
        return dp[i][j]=Math.max(iPiles, jPiles);
    }
}