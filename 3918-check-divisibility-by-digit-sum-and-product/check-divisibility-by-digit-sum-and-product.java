class Solution {
    public boolean checkDivisibility(int n) {
        long dig = 0;
        long prod  =1;
        int temp = n;
        while(temp!=0){
            dig += temp%10;
            prod *= temp%10;
            temp/=10;
        }

        return n%(dig+prod)==0;
    }
}