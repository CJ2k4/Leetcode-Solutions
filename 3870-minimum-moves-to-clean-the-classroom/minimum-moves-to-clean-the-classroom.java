class Solution {
    int[] dr = new int[]{0,0,-1,1};
    int[] dc = new int[]{-1,1,0,0};
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int r = -1, c=-1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];
        for(int[] a :  litterId){
            Arrays.fill(a, -1);
        }
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(classroom[i].charAt(j) == 'L'){
                    litterId[i][j]=litterCount;
                    litterCount++;
                }
                else if(classroom[i].charAt(j)=='S'){
                    r = i;
                    c = j;
                }
            }
        }

        //4 litter matlb --> 1111
        // 1<<4 = 10000 --> 10000-1 = 01111
        int mask = (1<<litterCount) - 1;
        if(mask == 0)return 0; //litter hai hi nahi

        int[][][] dp = new int[m][n][mask+1]; //r,c,energy,mask
        for(int[][] a:dp){
            for(int[] b : a){
                Arrays.fill(b, -1);
            }
        }
        dp[r][c][0] = energy;

        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{r,c,energy,0});
        
        int litterFound = 0;
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            steps++;

            for(int s= 0; s<size; s++){
                Integer[] state = q.poll();
                r = state[0];
                c = state[1];
                int e = state[2];
                int msk = state[3];

                for(int i = 0 ; i<4; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(nr>=0 && nr<classroom.length && nc>=0 && nc < classroom[0].length() && classroom[nr].charAt(nc)!='X' && e>0){

                        int ne = e-1;
                        int nm = msk;


                        if(classroom[nr].charAt(nc) == 'L'){
                            litterFound++;
                            nm |= 1<<litterId[nr][nc];
                        }else if(classroom[nr].charAt(nc) == 'R'){
                            ne = energy;
                        }

                        if(nm == mask)return steps;
                        
                        if(dp[nr][nc][nm]>=ne)continue;
                        dp[nr][nc][nm] = ne;
                        
                        q.add(new Integer[]{nr, nc, ne, nm});
                    }
                }
            }
        }
        return -1;
    }
}