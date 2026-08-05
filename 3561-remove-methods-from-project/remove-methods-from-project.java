class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> rev = new ArrayList<>();
        for(int i =0; i<n; i++)adj.add(new ArrayList<>());
        for(int i =0; i<n; i++)rev.add(new ArrayList<>());
        for(int[] i : invocations){
            adj.get(i[0]).add(i[1]);
            rev.get(i[1]).add(i[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(k);
        visited[k]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i : adj.get(curr)){
                if(!visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
                rev.get(i).remove(Integer.valueOf(curr));
            }
        }
        List<Integer> ans = new ArrayList<>();
        boolean canRemove = true;
        for(int i = 0; i<n; i++){
            if(visited[i]){
                if(!rev.get(i).isEmpty()){
                    canRemove = false;
                    break;
                }    
            }
        }
        if(!canRemove){
            for(int i=0;i<n; i++)ans.add(i);
        }else{
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}