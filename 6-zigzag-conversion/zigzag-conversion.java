class Solution {
    public String convert(String s, int r) {
        if(r==1)return s;
        StringBuilder sb  = new StringBuilder("");
        int i = 0;
        int n = s.length();
        while(i<n){
            sb.append(s.charAt(i));
            i = i + 2*r - 2;
        }
        for(i = 1; i<r-1; i++){
            int temp = i;
            while(temp<n){
                sb.append(s.charAt(temp));
                int d = temp+2*r - 2*i - 2;
                if(d < n)sb.append(s.charAt(d));
                temp = temp + 2*r - 2;
            }
        }
        i=r-1;
        while(i<n){
            sb.append(s.charAt(i));
            i = i + 2*r - 2;
        }
        return sb.toString();
    }
}