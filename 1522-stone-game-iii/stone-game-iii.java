class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int sum = 0;
        for(int val : stoneValue)sum+=val;
        dp = new Integer[stoneValue.length];
        int score = solve(stoneValue, 0);
        if(score>sum-score)return "Alice";
        else if (score == (sum-score))return "Tie";
        return "Bob";
    }
    Integer[] dp ;
    int solve(int[] sv, int i){
        //either take 1, or 2, or 3
        if(i>=sv.length)return 0;
        if(dp[i]!=null)return dp[i];
        int take1 = sv[i]+Math.min(solve(sv, i+2), Math.min(solve(sv, i+3), solve(sv, i+4)));
        int take2 = Integer.MIN_VALUE;
        if(i+1<sv.length)take2 =sv[i]+ sv[i+1]+ Math.min(solve(sv, i+3), Math.min(solve(sv, i+4), solve(sv, i+5)));
        int take3 = Integer.MIN_VALUE;
        if(i+2<sv.length)take3 =sv[i]+ sv[i+1]+ sv[i+2]+Math.min(solve(sv, i+4), Math.min(solve(sv, i+5), solve(sv, i+6)));
        
        return dp[i]=Math.max(take1, Math.max(take2, take3));
    }
}