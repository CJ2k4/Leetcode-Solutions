class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans = 0;
        for(int i = -(n+1); i<n; i++){
            for(int j = -(n+1); j<n; j++){
                ans = Math.max(ans, count(img1, img2, i, j, n));
            }
        }
        return ans;
    }
    int count(int[][] img1, int[][] img2, int i, int j, int n){
        int ans = 0;
        for(int row=Math.max(0, i); row<Math.min(n, n+i); row++){
            for(int col=Math.max(0, j); col<Math.min(n, j+n); col++){
                if((img1[row][col] & img2[row-i][col-j]) == 1)ans++;
            }
        }
        return ans;
    }
}