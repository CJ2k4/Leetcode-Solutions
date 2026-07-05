class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int MOD = 1000000007;
        int n = board.size();
        int [][] sum = new int[n][n];
        int [][] path = new int[n][n];

        for(int[] s : sum)Arrays.fill(s, -1);
        sum[n-1][n-1]=0;
        path[n-1][n-1]=1;
        for(int i = n-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(i==n-1 && j==n-1)continue;
                if(board.get(i).charAt(j)=='X')continue;

                int best = -1; int cnt = 0;
                int[][] src = {{i+1,j},{i, j+1}, {i+1,j+1}};

                for(int[] s : src){
                    int ni = s[0];
                    int nj = s[1];
                    if(ni<n && nj<n && sum[ni][nj]!=-1){
                        if(sum[ni][nj] > best){
                            best = sum[ni][nj];
                            cnt = path[ni][nj];
                        }
                        else if (sum[ni][nj] == best)cnt=(cnt+path[ni][nj])%MOD;
                    }
                }
                if(best == -1)continue;
                int val = board.get(i).charAt(j) == 'E' ? 0 : board.get(i).charAt(j) - '0';
                sum[i][j] = val + best;
                path[i][j] = cnt;
            }
        }
        if(sum[0][0]==-1)return new int[]{0,0};
        return new int[]{sum[0][0], path[0][0]};
    }
}