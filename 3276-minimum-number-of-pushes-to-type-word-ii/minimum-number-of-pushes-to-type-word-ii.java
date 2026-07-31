class Solution {
    public int minimumPushes(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int n = s.length();
        int push = 0;
        for(int i = 25; i>=0; i--){
            push += (freq[i]*((25-i)/8 + 1));
            if(freq[i]==0)break;
        }
        return push;
    }
}