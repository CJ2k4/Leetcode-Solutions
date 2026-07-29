class Solution {
    int sW;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        sW = shelfWidth;
        dp = new int[books.length][sW+1];
        for(int [] d : dp){
            Arrays.fill(d, -1);
        }
        return solve(books, sW, 0, 0);
    }
    int[][] dp;

    int solve(int[][] books, int remW, int i, int currH){
        if(i==books.length)return currH;
        if(dp[i][remW]!=-1)return dp[i][remW];
        int sameShelfHeight = Integer.MAX_VALUE;
        if(books[i][0]<=remW){
            sameShelfHeight = solve(books, remW-books[i][0], i+1, Math.max(currH, books[i][1]));
        }
        int nextShelfHeight = currH+solve(books, sW-books[i][0], i+1, books[i][1]);
        
        return dp[i][remW]=Math.min(sameShelfHeight, nextShelfHeight);
    }
}