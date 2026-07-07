class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : lower.toCharArray()){
            if((c<='z' && c>='a') || (c>='0' && c<='9'))sb.append(c);
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}