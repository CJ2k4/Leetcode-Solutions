class Solution {
    public int reverseDegree(String s) {
        int ans =0;
        int n = s.length();
        for(int i = 0; i<n; i++){
            int idx = i+1;
            int pos = s.charAt(i)-'a';
            int revPos = 26-pos;
            ans += (idx*revPos);
        }
        return ans;
    }
}