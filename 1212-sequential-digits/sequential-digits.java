class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i<=9;i++){
            q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr>=low && curr<=high){
                ans.add(curr);
            }
            int lastDig = curr%10;
            if(lastDig!=9 && curr<high){
                q.add(curr*10 + lastDig+1);
            }
        }
        return ans;
    }
}