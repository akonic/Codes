class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        for (int[] i : prerequisites) {
            adj.get(i[1]).add(i[0]);
        }
        int count = 0;
        int[] inDegree = new int[numCourses];
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            inDegree[i] = 0;
            visited[i] = 0;
        }
        for (int i = 0; i < numCourses; i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }

        }
        while (!q.isEmpty()) {
            int p = q.peek();
            q.poll();
            count++;
            for (int i : adj.get(p)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        if (count == numCourses) {
            return true;
        }
        return false;
    }
}