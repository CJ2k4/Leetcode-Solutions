class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for(char c : s.toCharArray() ){
            freq[c-'a']++;
        }

        int[] halfFreq= new int[26];
        for(int i =0; i<26; i++){
            halfFreq[i]=freq[i]/2;
        }

        int count = s.length()/2;
        StringBuilder sb = new StringBuilder();
        while(count>0){
            boolean chosen = false;
            for(int i = 0; i<26; i++){
                if(halfFreq[i]>0){
                    halfFreq[i]--;
                    long comb = countPermutations(halfFreq, count-1, k);
                    if(k-comb > 0){
                        k-=comb;
                        halfFreq[i]++;
                    }else {
                        sb.append((char)('a' + i));
                        chosen = true;
                        count--;
                        break;
                    }
                }
            }
            if(!chosen)return "";
        }
        StringBuilder rev  = new StringBuilder(sb).reverse();
        for(int i = 0; i<26; i++){
            if(freq[i]%2!=0){
                sb.append((char)('a'+i));
                break;
            }
        }
        sb.append(rev);
        return sb.toString();

    }

    long countPermutations(int[] freq, int total, long limit) {
        long ways = 1;
        int remaining = total;

        for (int f : freq) {
            if (f == 0) continue;

            ways *= nCrLimited(remaining, f, limit);

            if (ways > limit) {
                return limit + 1;
            }

            remaining -= f;
        }

        return ways;
    }
    long nCrLimited(int n, int r, long limit) {
        if (r > n) return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;

            if (ans > limit) {
                return limit + 1;
            }
        }

        return ans;
    }
}