class Solution {
    public int minimizedMaximum(int n, int[] q) {
        int high = 0;
        for(int i : q)high = Math.max(high, i);
        int low = 1;
        int ans =0;
        while(low <= high){
            int mid = low + (high - low)/2;
            int num = 0;
            for(int i : q)num += (i+mid-1)/mid;
            if(num <= n){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}