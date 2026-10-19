class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0; 
        int j = n-1;
        while(i<=j){
            while(i<n && !valid(i,s))i++;
            while(j>=0 && !valid(j,s))j--;
            if(i<n && j>=0 && i<=j){
                if(normalize(i,s) != normalize(j,s))return false;
            }
            i++;
            j--;
        }
        return true;
    }
    boolean valid(int i, String s){
        char ch = s.charAt(i);
        if(ch>='a' && ch<='z')return true;
        if(ch>='A' && ch<='Z')return true;
        if(ch>='0' && ch<='9')return true;
        return false;
    }
    char normalize(int i, String s){
        char ch = s.charAt(i);
        if(ch>='A' && ch<='Z')return (char)(ch+32);
        return ch;
    }
}