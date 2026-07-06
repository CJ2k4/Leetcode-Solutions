class Solution {
    public void solveSudoku(char[][] board) {
        fixed = new boolean[9][9];
        for(int i = 0; i<9; i++){
            for(int j= 0; j<9; j++){
                if(board[i][j]!='.')fixed[i][j] = true;
            }
        }
        solve(board,0,0);
    }

    boolean[][] fixed;

    boolean solve(char[][] board, int i, int j){
        if(i==9 )return true;

        if(fixed[i][j]){
            return solve(board, i+ (j+1)/9, (j+1)%9);
        }
        for(int k = 1; k<=9; k++){
            if(check(i, j, k, board)){
                board[i][j] = Character.forDigit(k, 10);
                if(solve(board, i + (j+1)/9, (j+1)%9))return true;
                board[i][j]='.';
            }
        }
        return false;
    }

    boolean check(int i, int j, int k, char[][] board){
        for(int t = 0; t<9; t++){
            if(board[i][t]==Character.forDigit(k, 10))return false;
        }
        for(int t=0; t<9; t++){
            if(board[t][j]==Character.forDigit(k, 10))return false;
        }
        for(int t = i/3 * 3; t<i/3 * 3 +3; t++){
            for(int u = j/3 * 3; u<j/3 * 3 + 3; u++){
                if(board[t][u]==Character.forDigit(k, 10))return false;
            }
        }
        return true;

    }

}