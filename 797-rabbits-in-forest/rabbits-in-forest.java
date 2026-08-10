class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : answers) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
            int a = m.getKey();
            int b = m.getValue();

            ans += ((b / (a + 1)) * (a + 1));

            if (b % (a + 1) != 0) {
                ans += a + 1;
            }

        }

        return ans;
    }
}