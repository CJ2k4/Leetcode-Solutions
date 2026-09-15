class Solution {
    public int maxPalindromes(String s, int k) {
        n= s.length();
        dp = new int[n+1][n+1];
        isPal= new boolean[n][n];
        isPalindrome(s);
        for(int i =n-1; i>=0; i--){
            for(int j =n-1; j>=0; j--){
                if(isPal[i][j]){
                    int take = 1;
                    if(j+1<=n && j+k<=n)
                        take+=dp[j+1][j+k];
                    int grow = 0;
                    if(j+1<=n)
                        grow = dp[i][j+1];
                    int slide = 0;
                    if(i+1<=n && j+1<=n)
                        slide = dp[i+1][j+1];
                    dp[i][j]=Math.max(take, Math.max(grow, slide));
                    continue;
                }
                int grow = 0;
                if(j+1<n)
                    grow= dp[i][j+1];
                int slide=0;
                if(i+1<n && j+1<n)
                    slide = dp[i+1][j+1];
                dp[i][j]= Math.max(grow, slide);
            }
        }
        return dp[0][k-1];
    }
    int[][] dp;
    boolean[][] isPal;
    int n;
    
    void isPalindrome(String s){
        for(int L=1; L<=n; L++){
            for(int i=0; i+L<=n; i++){
                int j =i+L-1;
                if(i==j){
                    isPal[i][j]=true;
                }else if(i+1==j){
                    isPal[i][j] = (s.charAt(i)==s.charAt(j));
                }else{
                    isPal[i][j] = ((s.charAt(i)==s.charAt(j))&&(isPal[i+1][j-1])) ? true:false;
                }
            }
        }
    }
}