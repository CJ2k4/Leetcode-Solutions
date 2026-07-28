class Solution {
    public String multiply(String num1, String num2) {
        int[] arr = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1; i>=0; i--){
            int ith = num1.charAt(i)-'0';
            int carry = 0;
            for(int j=num2.length()-1; j>=0; j--){
                int jth = num2.charAt(j)-'0';
                int mul = ith*jth ;
                int sum = mul + arr[i+j+1] + carry;
                arr[i+j+1] = sum%10;
                carry=sum/10;
            }
            arr[i]+=carry;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<arr.length && arr[i]==0)i++;
        for(;i<arr.length; i++){
            sb.append(arr[i]);
        }
        if(sb.toString().equals(""))return "0";
        return sb.toString();
    }
}