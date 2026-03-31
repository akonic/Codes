class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n];
        int mx = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            dist[i] = mx;
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0] - 1).add(new int[] { times[i][2], times[i][1] - 1 });
        }

        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[] { 0, k - 1 });

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int newDist = top[0];
            int node = top[1];
            for (int[] i : adj.get(node)) {
                if (i[0] + newDist < dist[i[1]]) {
                    dist[i[1]] = i[0] + newDist;
                    pq.offer(new int[] { i[0] + newDist, i[1] });
                }
            }
        }

        int ans = 0;
        int p = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist[i] == mx) {
                return -1;
            }
            p = Math.max(p, dist[i]);
        }
        return p;
    }
}