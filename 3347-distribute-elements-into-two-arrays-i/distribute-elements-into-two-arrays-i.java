class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        if(n<=2)return nums;
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int i=0, j=0;
        for(int k = 2; k<n; k++){
            if(arr1[i]>arr2[j]){
                arr1[++i] = nums[k];
            }else{
                arr2[++j] = nums[k];
            }
        }
        i=0;int k=0;
        while(arr1[i]!=0){
            nums[k++]=arr1[i++];
        }
        i=0;
        while(arr2[i]!=0){
            nums[k++]=arr2[i++];
        }
        return nums;
    }
}