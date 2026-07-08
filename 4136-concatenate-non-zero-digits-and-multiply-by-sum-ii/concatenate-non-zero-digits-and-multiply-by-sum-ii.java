class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int MOD = 1000000007;

        int[] prefixSum = new int[s.length()];
        prefixSum[0] = s.charAt(0) - '0';
        int[] countZ = new int[s.length()];
        countZ[0] = (prefixSum[0] == 0) ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            prefixSum[i] = prefixSum[i - 1] + (s.charAt(i) - '0');
            if (s.charAt(i) != '0')
                countZ[i] = countZ[i - 1] + 1;
            else
                countZ[i] = countZ[i - 1];
        }

        long[] pow10 = new long[s.length() + 1];
        pow10[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int[] pConcat = new int[s.length()];
        if (s.charAt(0) == '0')
            pConcat[0] = 0;
        else
            pConcat[0] = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                if (pConcat[i - 1] == -1)
                    pConcat[i] = (s.charAt(i) - '0');
                else
                    pConcat[i] = (int) (((long) pConcat[i - 1] * 10) % MOD + (s.charAt(i) - '0')) % MOD;
            } else
                pConcat[i] = pConcat[i - 1];
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int cnt = countZ[q[1]] - ((q[0]==0)? 0 : countZ[q[0]-1]);
            int sum = prefixSum[q[1]] - ((q[0] == 0) ? 0 : prefixSum[q[0] - 1]);

            long num = pConcat[q[1]];
            long remove = ((long)(q[0]==0 ? 0 : pConcat[q[0]-1])*pow10[cnt])%MOD;
            num = ( num - remove + MOD)%MOD;

            ans[i++] = (int) ((num * sum) % MOD);
        }
        return ans;
    }
}