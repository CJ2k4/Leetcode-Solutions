class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] ve = bfs(i, edges, visited, 0, 0, adj);
                int v = ve[0], e = ve[1];
                if ((v*(v-1)) == e)
                    count++;
            }
        }
        return count;
    }
    int[] bfs(int i ,int[][] edges, boolean[] visited, int v, int e, List<List<Integer>> adj){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            e+=adj.get(node).size();
            v++;
            for(int ngbr : adj.get(node)){
                if(!visited[ngbr]){
                    visited[ngbr] = true;
                    q.add(ngbr);
                }
            }
        }
        return new int[]{v,e};
    }
}