class Solution {
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        int[][] marked = new int[n][n];
        for(int [] m : marked){
            Arrays.fill(m, -2);
        }
        solve(0,n, marked);
        return ans;
    }
    List<List<String>> ans;
    void solve(int r, int n, int[][] marked){
        if(r==n){
            List<String> a = new ArrayList<>();
            for(int[] i : marked){
                StringBuilder sb = new StringBuilder();
                sb.append(".".repeat(n));
                for(int j=0; j<n; j++){
                    if(i[j]==-1){sb.setCharAt(j, 'Q');break;}
                }
                a.add(sb.toString());
            }
            ans.add(a);
            return;
        }
        for(int i=0; i<n; i++){
            if(marked[r][i]==-2){
                marked[r][i]=-1;
                for(int j = r+1; j<n; j++){
                    if(marked[j][i]!=-2)continue;
                    else marked[j][i] = r;
                }
                int d = i-1;
                int j = r+1;
                while(d>=0 && j<n ){
                    if(marked[j][d]==-2)marked[j][d] = r;
                    j++;d--;
                }
                d = i+1;
                j=r+1;
                while(d<n && j<n ){
                    if(marked[j][d]==-2)marked[j][d]=r;
                    j++;d++;
                }
                solve(r+1, n, marked);
                marked[r][i]=-2;
                for(j=r+1; j<n; j++){
                    for(d=0; d<n; d++){
                        if(marked[j][d]==r)marked[j][d]=-2;
                    }
                }
            }
        }
        return;
    }
}