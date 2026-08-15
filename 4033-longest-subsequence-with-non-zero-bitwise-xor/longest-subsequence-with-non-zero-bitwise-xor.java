class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean nz = false;
        for(int i : nums){
            if(!nz && i!=0)nz = true;
            xor = xor^i;
        }
        if(nz == false)return 0;
        if(xor == 0)return nums.length-1;
        return nums.length;
    }
    
}