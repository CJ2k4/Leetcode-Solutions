class Solution {

    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minidx = 0,
            maxidx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minidx]) {
                minidx = i;
            }
            if (nums[i] > nums[maxidx]) {
                maxidx = i;
            }
        }

        int minPos1 = Math.min(minidx, maxidx); 
        int minPos2 = Math.max(minidx, maxidx); 

        return Math.min(Math.min(minPos2 + 1, n - minPos1), minPos1 + 1 + n - minPos2);
    }
}