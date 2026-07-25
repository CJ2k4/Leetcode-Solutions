class Solution {
    public int maxProduct(int n) {
        int[] dig = new int[10];
        while(n>0){
            int d = n%10;
            dig[d]++;
            n/=10;
        }
        int ans = 1;
        int take = 0;
        for(int i = 9; i>0; i--){
            while(dig[i]!=0 && take!=2)
            {
                ans*=i;
                dig[i]--;
                take++;
            }
        }
        if(take<2)return 0;
        return ans;
    }
}