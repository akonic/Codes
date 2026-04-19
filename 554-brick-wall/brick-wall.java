class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Long, Integer> mp = new HashMap<>();
        int n = wall.size();

        for (List<Integer> row : wall) {
            long sum = 0;

            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                mp.put(sum, mp.getOrDefault(sum, 0) + 1);
            }
        }

        int val = 0;

        for (int count : mp.values()) {
            if (count > val) {
                val = count;
            }
        }

        return n - val;
    }
}