class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int d =0;
        int n = seq.length();
        for(int i = 0;i<n; i++){
            char ch = seq.charAt(i);
            if(ch=='('){
                d++;
                ans[i]= d%2;
            }else{
                ans[i]=d%2;
                d--;
            }
        }
        return ans;
    }
}