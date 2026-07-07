class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        while(n>0){
            int dig = n%10;
            if(dig != 0) st.add(dig);
            sum+=dig;
            n/=10;
        }
        long x=0;
        while(!st.isEmpty()){
            x = x*10 + st.pop();
        }
        return x*sum;
    }
}