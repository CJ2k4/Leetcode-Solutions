class Solution {
    public int minEatingSpeed(int[] p, int h) {
        int low = 1;
        int max = p[0];
        for(int i : p)max = Math.max(max, i);
        int high = max;
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low)/2;

            long time = 0;
            for(int i : p)time += (i+mid-1)/mid;
            if(time<=h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}