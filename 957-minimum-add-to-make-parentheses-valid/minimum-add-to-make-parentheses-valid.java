class Solution {
    public int minAddToMakeValid(String s) {
        int i = 0;
        int n = s.length();
        int depth = 0;
        int ans = 0;
        while(i<n){
            if(s.charAt(i)=='('){
                depth++;
            }else{
                if(depth == 0){
                    ans++;
                }else{
                    depth--;
                }
            }
            i++;
        }

        return ans+depth;
    }
}