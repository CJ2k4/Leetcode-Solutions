class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum = 0;
        for(int i=0; i<n; i++){
            Set<Integer> numInSubarray = new HashSet<>();
            for(int j = i; j<n; j++){
                numInSubarray.add(nums.get(j));
                int s = numInSubarray.size();
                sum+= (s*s);
            }
        }
        return sum;
    }
}