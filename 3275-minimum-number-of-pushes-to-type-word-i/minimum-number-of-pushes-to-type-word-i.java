class Solution {
    public int minimumPushes(String word) {
        Integer[] freq = new Integer[26];
        for(int i=0; i<26; i++){
            freq[i]=0;
        }
        for(char c : word.toCharArray()){
            freq[c-'a']++;
        }

        int ans = 0;
        Arrays.sort(freq, Collections.reverseOrder());
        for(int i=0; i<26; i++){
            if(freq[i]==0)break;
            ans =ans +  (i/8 + 1)*freq[i];
        }
        return ans;
    }
}