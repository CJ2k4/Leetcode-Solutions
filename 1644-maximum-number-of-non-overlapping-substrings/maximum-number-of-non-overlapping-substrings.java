class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        Arrays.fill(first, -1);
        int[] last = new int[26];
        int n = s.length();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(first[c-'a']==-1)first[c-'a']=i;
            last[c-'a']=i;
        }
        boolean[] isValid = new boolean[26];
        Arrays.fill(isValid, true);
        for(int i = 0; i<26; i++){
            if(first[i]==-1)continue;
            for(int j = first[i]; j<last[i]; j++){
                int idx = s.charAt(j)-'a';
                if(first[idx]<first[i]){
                    isValid[i]=false;
                    break;
                }
                last[i] = Math.max(last[i], last[s.charAt(j)-'a']);
            }
        }
        int lastTakenStart = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            int idx=s.charAt(i)-'a';
            if(!isValid[idx])continue;
            if(i == first[idx] && last[idx]<lastTakenStart){
                ans.add(s.substring(first[idx], last[idx]+1));
                lastTakenStart = first[idx];
            }
        }
        return ans;
    }
}