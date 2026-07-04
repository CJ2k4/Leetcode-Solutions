/**
    n nodes -> 0 to n-1
    edges[][] = m x 3
    edges[i] = [ui, vi, costi]
    online[i] = true/false , (0,n-1 -> true)
    valid -> all nodes online in path & cost(all nodes) <= k
    score -> min(edge cost in the path)
    return max(score between all the path)
    else return -1
 */
class Pair implements Comparable<Pair>{
    long a;
    int b;
    Pair(long a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(Pair p){
        return Long.compare(this.a, p.a);
    }
}
class Solution {
    public int findMaxPathScore(int[][] e, boolean[] o, long k) {
        List<List<int[]>> adj = new ArrayList<>();
        int n = o.length;
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int l = Integer.MAX_VALUE;
        int r = 0;
        for(int[] p : e){
            int u = p[0];
            int v = p[1];
            int c = p[2];
            if(!o[u] || !o[v])continue;
            adj.get(u).add(new int[]{v,c});
            l = Math.min(l, c);
            r = Math.max(r, c);
        }  
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;

            if(check(mid, n, k, adj)){
                ans = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return ans;
    }

    boolean check(int mid, int n, long k, List<List<int[]>> adj){
        long[] result = new long[n];
        Arrays.fill(result, Long.MAX_VALUE);
        PriorityQueue<Pair> pq=  new PriorityQueue<>();
        
        result[0] = 0;
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            long d = pq.peek().a;
            int node = pq.peek().b;
            pq.poll();

            if(d>k)return false;

            if(node == n-1)return true;

            if(result[node]<d){
                continue;
            }

            for(int[] l : adj.get(node)){
                int ngbr = (int)l[0];
                int c = l[1];

                if(c<mid){
                    continue;
                }

                if(d+c < result[ngbr]){
                    result[ngbr] = d+c;
                    pq.add(new Pair(d+c, ngbr));
                }
            }
        }
        return false;
    }
}