class Solution {
    public long countCommas(long n) {
        long ans = 0;
        // int range1 = 1.000 to 999.999
        // int range2 = 1.000.000 to 999.999.999
        // int range3 = 1.000.000.000 to 999.999.999.999
        // int range4 = 1.000.000.000.000 to 1.000.000.000.000.000
        // System.out.println(Long.MAX_VALUE);
        if(n>=1000)ans+=n-999;
        if(n>=1000000)ans=ans + (n-999999);
        if(n>=1000000000L)ans=ans+(n-999999999L);
        if(n>=1000000000000L)ans=ans+(n-999999999999L);
        if(n>=1000000000000000L)ans=ans+(n-999999999999999L);
        return ans;
    }
}