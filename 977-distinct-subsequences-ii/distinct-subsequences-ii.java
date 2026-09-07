class Solution {
    int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        int n = s.length();
        dp = new long[n];
        Arrays.fill(dp, -1);
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        this.s = s;
        prev = new int[n];
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            prev[i] = lastSeen[c];
            lastSeen[c] = i;
        }
        return (int) (solve(s.length() - 1)) % MOD;
    }

    String s;
    long[] dp;
    int[] prev;

    long solve(int n) {
        if (n < 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        long total = (2 * solve(n - 1) + 1) % MOD;
        int duplicates = 0;
        if (prev[n] != -1)
            total = (total - (solve(prev[n] - 1) + 1) + MOD) % MOD;
        return dp[n] = (total);
    }
}
