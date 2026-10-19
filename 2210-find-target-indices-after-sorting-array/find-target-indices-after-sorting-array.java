class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean inside = false;
        int n = nums.length;
        for(int i =0; i<n; i++){
            while(i<n && nums[i] == target){
                ans.add(i);
                i++;
                inside = true;
            }
            if(inside)break;
        }
        return ans;
    }
}