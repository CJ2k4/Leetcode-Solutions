class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)set.add(num);

        int ans = 0;
        for(int num : set){
            if(set.contains(num-1))continue;
            int start = num;
            int temp = 1 ;
            while(set.contains(++start))temp++;
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}