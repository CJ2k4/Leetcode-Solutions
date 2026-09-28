class Solution {
    public int maxDepth(String s) {
        int ans= 0;
        int max =0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                ans++;
            }else if(ch==')'){
                ans--;
            }
            max=Math.max(ans,max);
        }
        return max;
    }
}