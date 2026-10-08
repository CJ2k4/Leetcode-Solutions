class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int j = 0;
        int count =0;
        StringBuilder sb = new StringBuilder();
        while(j<n){
            if(s.charAt(j)=='('){
                if(count>0)sb.append('(');   
                count++;
            }
            else {
                count--;
                if(count>0)sb.append(')');
            }
            j++;
        }
        return sb.toString();
    }
}