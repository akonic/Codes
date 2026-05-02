class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int a = nums[i];
            if (i > 0 && nums[i] == nums[i-1]) continue;
            mp.put(a, mp.get(a) - 1);

            for (int j = i + 1; j < n; j++) {
                int b = nums[j];
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                mp.put(b, mp.get(b) - 1); 

                int p = -a - b;

                if (mp.getOrDefault(p, 0) > 0) {
                    List<Integer> triplet = Arrays.asList(a, b, p);
                    Collections.sort(triplet);
                    set.add(triplet);
                }

                mp.put(b, mp.get(b) + 1); 
            }

            mp.put(a, mp.get(a) + 1);
        }

        return new ArrayList<>(set);
    }
}