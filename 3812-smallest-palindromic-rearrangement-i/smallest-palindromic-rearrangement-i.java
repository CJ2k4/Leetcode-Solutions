class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()<2)return s;
        PriorityQueue<Character> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i<n/2; i++){
            pq.add(s.charAt(i));
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        StringBuilder rev = new StringBuilder(sb);
        if(n%2!=0){
            sb.append(s.charAt(n/2));
        }
        rev.reverse();
        sb.append(rev);
        return sb.toString();
    }
}