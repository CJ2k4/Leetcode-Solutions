class Solution {
    static int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] sym = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<13; i++){
            if(num == 0)break;
            int time = num/val[i];
            while(time-->0){
                sb.append(sym[i]);
            }
            num = num%val[i];
        }
        return sb.toString();
    }
}