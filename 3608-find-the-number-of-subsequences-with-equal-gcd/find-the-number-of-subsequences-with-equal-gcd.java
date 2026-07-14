class Solution {
    public int subsequencePairCount(int[] nums) {
        dp= new int[nums.length + 1][201][201];
        for(int[][] a : dp){
            for(int[] b: a){
                Arrays.fill(b, -1);
            }
        }
        return solve(nums, 0, 0, 0);
    }
    static int MOD = 1000000007;
    int[][][] dp;
    int solve(int[] nums, int i, int gcd1, int gcd2){
        if(i==nums.length){
            if(gcd1!=0 && gcd2!=0 && gcd1==gcd2)return 1;
            return 0;
        }
        if(dp[i][gcd1][gcd2]!=-1)return dp[i][gcd1][gcd2];
        int skip = solve(nums, i+1, gcd1, gcd2);
        int take1 = solve(nums, i+1, gcd(gcd1, nums[i]), gcd2);
        int take2 = solve(nums, i+1, gcd1, gcd(gcd2,nums[i]));
        return dp[i][gcd1][gcd2]=(int)(((long)skip+take1+take2)%MOD);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}