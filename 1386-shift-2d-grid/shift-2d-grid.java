class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length,  n = grid[0].length;
        int total = m*n;
        k%=total;
        int[][] res = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int nr = ((n*i + j + k)%total)/n;
                int nc = ((i*n + j + k)%total)%n;
                res[nr][nc] = grid[i][j];
            }
        }
        List<List<Integer>> ans= new ArrayList<>();
        for(int i = 0; i<res.length; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j<res[0].length; j++){
                ans.get(i).add(res[i][j]);
            }
        }
        return ans;
    }
}