class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        Map<Integer, Integer> m = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int i = entry.getValue();
          m.put(i, m.getOrDefault(i, 0) + 1);
        }

        for (int x : nums) {
            if (m.get(mp.get(x)) == 1) {
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