class Solution {
    public boolean isMatch(String s, String p) {
        // .-> any char
        // *->0-more of the preceding element
        return solve(s, p, 0, 0);
    }
    boolean solve(String s, String p, int i, int j){
        if (j == p.length())
            return i == s.length();

        boolean match = i<s.length() && ((s.charAt(i)==p.charAt(j)) || p.charAt(j)=='.');
        if( j+1<p.length() && p.charAt(j+1) == '*'){
            return solve(s, p, i, j+2) || (match && solve(s,p,i+1, j));
        }else if(match){
            return solve(s, p, i+1, j+1);
        }
        return false;
    }
}