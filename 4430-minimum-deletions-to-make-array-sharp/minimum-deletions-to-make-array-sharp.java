class Solution {
    public int minDeletions(int[] nums) {
        Deque<Integer> stack = new  ArrayDeque<>();
        for(int i : nums){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && (i^stack.peek()) == 0)stack.pop();
                stack.push(i);
            }
        }
        return nums.length - stack.size();
    }
}