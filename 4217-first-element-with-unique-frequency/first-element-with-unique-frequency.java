class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {

            m.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        for (int x : nums) {
            if (m.get(mp.get(x)).size() == 1) {
                return x;
            }
        }
        return -1;
    }
}

/*
20 - 2 
10 - 1
30 - 3


*/