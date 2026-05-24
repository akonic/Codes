class Solution {
    private boolean check(String a, String b) {
        int c = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                c++;
                if (c > 1) {
                    return false;
                }
            }
        }
        if (c == 1)
            return true;

        return false;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(0, beginWord);
        int n = wordList.size();
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (check(wordList.get(i), wordList.get(j))) {
                    ls.get(i).add(j);
                    ls.get(j).add(i);
                }
            }

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[n];
        int ans = 0;
        pq.offer(new int[] { 1, 0 });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int cost = top[0];
            int node = top[1];
            if (visited[node])
                continue;
            visited[node] = true;
            for (int i : ls.get(node)) {
                if (wordList.get(i).equals(endWord)) {
                    return cost + 1;
                }
                pq.offer(new int[] { cost + 1, i });
            }
        }
        return 0;
    }
}