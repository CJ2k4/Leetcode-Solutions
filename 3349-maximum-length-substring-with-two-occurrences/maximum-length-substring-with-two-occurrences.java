class Solution {
    public int maximumLengthSubstring(String s) {
        int i = 0 ; 
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        int ans = 0;
        for(int end = 0; end<n; end++){
            char cur = s.charAt(end);
            if(freq.getOrDefault(cur, 0) == 2){
                ans = Math.max(ans, end-i);
                while(s.charAt(i)!=cur){
                    freq.put(s.charAt(i), freq.get(s.charAt(i))-1);
                    if(freq.get(s.charAt(i)) == 0)freq.remove(s.charAt(i));
                    i++;
                }
                i++;
            }else{
                freq.put(cur, freq.getOrDefault(cur, 0)+1);
            }
        }
        ans = Math.max(ans, n-i);
        return ans;
    }
}