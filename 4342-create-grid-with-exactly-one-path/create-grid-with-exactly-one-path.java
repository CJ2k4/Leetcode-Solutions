class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        int idx = 0;
        String s = ".".repeat(n);
        ans[0] = s;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n-1; i++){
            sb.append('#');
        }
        sb.append('.');
        for(int i =1; i<m; i++){
            ans[i] = sb.toString();
        }

        return ans;
    }
}