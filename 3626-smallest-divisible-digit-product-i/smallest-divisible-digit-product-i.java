class Solution {
    public int smallestNumber(int n, int t) {
        while(!solve(n, t)){
            n++;
        }
        return n;
        
    }

    boolean solve(int n, int t){
        int temp=n;
        int product = 1;
        while(temp!=0){
            product*=temp%10;
            temp/=10;
        }
        if(product%t==0)return true;
        return false;
    }
}