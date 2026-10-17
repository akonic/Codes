class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        int[] last = new int[26];
        Arrays.fill(last, -1);
        boolean flag = true;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b, a));
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        while (!pq.isEmpty() || !q.isEmpty()) {
            ans++;
            if (!pq.isEmpty()) {
                int x = pq.poll();
                x--;
                if (x != 0) {
                    q.offer(new int[] { ans + n, x });
                }
            }
            while (!q.isEmpty() && q.peek()[0] == ans) {
                pq.offer(q.poll()[1]);
            }
        }
        return ans;
    }
}