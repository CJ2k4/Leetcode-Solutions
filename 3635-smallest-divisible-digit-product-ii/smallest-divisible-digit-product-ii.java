class Solution {
    public String smallestNumber(String num, long t) {
        long temp = t;

        int n = num.length();
        for(int i : new int[]{2, 3, 5, 7}){
            while(temp%i==0)temp/=i;
        }

        if(temp!=1)return "-1";

        long[] rem = new long[n+1];
        Arrays.fill(rem, t);
        
        boolean hasZero = false;
        for(int i =0; i<n; i++){
            int dig = num.charAt(i) - '0';
            if(dig == 0){
                hasZero = true;
                break;
            }
            rem[i+1]=rem[i]/(gcd(rem[i], dig));
        }
        if(!hasZero && rem[n]==1)return num;

        int zeroPos= num.indexOf('0');
        int zeroIdx = n-1;

        if(zeroPos !=-1)zeroIdx = zeroPos;

        for(int i = zeroIdx; i>=0; i--){
            long req = rem[i];
            int freeSlots = n-1-i;

            for(int dig = (num.charAt(i)-'0')+1; dig<=9; dig++){
                long furtherReq = req/(gcd(req, dig));

                String reqNum = func(furtherReq, freeSlots);

                if(reqNum.length() == freeSlots){
                    return num.substring(0, i) + (char)(dig + '0') + reqNum;
                }
            }
        }

        return func(t, n+1);

    }

    static String func(long req, int length){
        StringBuilder sb = new StringBuilder();

        for(int dig=9; dig>1; dig--){
            while(req%dig == 0){
                req/=dig;
                sb.append(dig);
            }
        }

        while(sb.length() < length){
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}