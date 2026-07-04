class Solution {
    public int minScore(int n, int[][] roads) {
        /*
            n -> 1 to n
            roads[][]
            roads[i] = a to b with d
             score = min(d in that path)
        */

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r : roads){
            int a = r[0];
            int b = r[1];
            int d = r[2];
            adj.get(a-1).add(new int[]{b-1,d});
            adj.get(b-1).add(new int[]{a-1,d});
        }
        int min = Integer.MAX_VALUE;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        boolean[] visited=new boolean[n];
        while(!q.isEmpty()){
            int node = q.poll();
            visited[node]=true;
            for(int[] t : adj.get(node)){
                int to = t[0];
                if(visited[to])continue;
                int dis = t[1];
                min = Math.min(dis, min);
                q.add(to);
            }
        }
        return min;
    }
}