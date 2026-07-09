class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        int[] dirs = {0, 1, 0, -1, 0};

        // Step 1: multi-source BFS from all thieves
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                if (grid.get(r).get(c) == 1) {
                    q.add(new int[]{r, c});
                    dist[r][c] = 0;
                }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dirs[d], nc = cur[1] + dirs[d+1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        // Step 2: max-heap best-first search maximizing the bottleneck
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] seen = new boolean[n][n];
        pq.add(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int safe = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == n - 1) return safe;
            if (seen[r][c]) continue;
            seen[r][c] = true;
            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d], nc = c + dirs[d+1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !seen[nr][nc]) {
                    pq.add(new int[]{Math.min(safe, dist[nr][nc]), nr, nc});
                }
            }
        }
        return 0;
    }
}