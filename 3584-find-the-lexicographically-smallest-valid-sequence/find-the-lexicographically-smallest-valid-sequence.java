class Solution {
    public int[] validSequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(n>m)return new int[]{};
        int[] suf = new int[m+1];
        int cur = n-1;
        suf[m]=0;
        for(int i=m-1; i>=0; i--){
            suf[i]=suf[i+1];
            if(cur>=0 && word1.charAt(i)==word2.charAt(cur)){
                suf[i]++;
                cur--;
            }
        }
        int[] ans = new int[n];
        cur= 0;
        boolean used = false;
        for(int i = 0; i<m && cur<n; i++){
            if(word1.charAt(i)==word2.charAt(cur)){
                ans[cur]=i;
                cur++;
            }else if(!used && suf[i+1]>=n-cur-1){
                used = true;
                ans[cur]=i;
                cur++;
            }
        }
        return cur==n ? ans : new int[]{};
    }
}