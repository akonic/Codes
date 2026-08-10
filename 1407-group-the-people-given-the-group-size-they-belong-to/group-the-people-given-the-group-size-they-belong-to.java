class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(groupSizes[i])) {
                mp.get(groupSizes[i]).add(i);
            } else {
                mp.put(groupSizes[i], new ArrayList<>());
                mp.get(groupSizes[i]).add(i);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (var entry : mp.entrySet()) {
            int a = entry.getKey();
            List<Integer> ls = entry.getValue();
            List<Integer> temp = new ArrayList<>();
            int size = 0;
            for (int i : ls) {
                temp.add(i);
                size++;

                if (size == a) {
                    ans.add(new ArrayList<>(temp));
                    temp.clear();
                    size = 0;
                }
            }
        }

        return ans;
    }
}