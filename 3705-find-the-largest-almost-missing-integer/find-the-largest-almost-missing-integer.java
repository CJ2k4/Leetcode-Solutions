class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<k; i++){
            if(!set.contains(nums[i])){
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
                set.add(nums[i]);
            }
        }
        set.clear();
        for(int i = 1; i<n-k+1; i++){
            for(int j = 0; j<k; j++){
                if(!set.contains(nums[i+j])){
                    map.put(nums[i+j], map.getOrDefault(nums[j+i], 0)+1);
                    set.add(nums[i+j]);
                }
            }
            set.clear();
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1)ans = Math.max(entry.getKey(), ans);
        }

        return ans;
    }
}