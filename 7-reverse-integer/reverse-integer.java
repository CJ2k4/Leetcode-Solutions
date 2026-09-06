class Solution {
    public int reverse(int x) {
        int ans = 0;
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println(Integer.MIN_VALUE);
        while(x!=0){
            int dig = x%10;
            x= x/10;
            if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE && dig>0))return 0;
            if(ans<Integer.MIN_VALUE/10 || (ans==Integer.MIN_VALUE && dig<-8))return 0;
            ans = ans*10 + dig;
        }
        return ans;
    }
}