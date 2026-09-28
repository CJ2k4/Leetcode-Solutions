class Solution {
    public int maxDepth(String s) {
        int ans= 0;
        int max =0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                ans++;
                max=Math.max(ans,max);
            }else if(ch==')'){
                ans--;
            }
        }
        return max;
    }
}