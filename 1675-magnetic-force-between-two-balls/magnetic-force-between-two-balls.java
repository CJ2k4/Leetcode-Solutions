class Solution {
    public int maxDistance(int[] p, int m) {
        int n = p.length;


        Arrays.sort(p);

        int low = 1, high = p[n-1]-p[0];
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;

            int temp = m;
            int next = p[0];
            for(int i = 0; i<n; i++){
                if(p[i]>=next){
                    temp--;
                    next = p[i]+mid;
                }
            }
            if(temp<=0){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}