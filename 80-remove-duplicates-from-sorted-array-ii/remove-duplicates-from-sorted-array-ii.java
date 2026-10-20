class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        int currEle = nums[0];
        int count = 1;
        int n = nums.length;
        while(j<n){
            if((nums[j] == currEle) && count<2){
                nums[i] = nums[j];
                count++;
                i++;
            }else if(nums[j] != currEle){
                nums[i] = nums[j];
                count = 1;
                currEle = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}