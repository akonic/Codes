class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            ls.get(nums[i] % k).add(i);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = Math.max(ans, ls.get(i).size());
            for (int j = i + 1; j < k; j++) {
                int prev = 0;
                int ind1 = 0, ind2 = 0;
                if (ls.get(i).size() > 0 && ls.get(j).size() > 0 && ls.get(i).get(0) > ls.get(j).get(0)) {
                    prev = 1;
                }

                int cur = 0;
                while (ind1 < ls.get(i).size() && ind2 < ls.get(j).size()) {
                    if (prev == 1) {
                        if (ls.get(i).get(ind1) > ls.get(j).get(ind2)) {
                            cur++;
                            ind2++;
                            prev = 0;
                        } else {
                            ind1++;
                            prev = 1;
                        }
                    } else {
                        if (ls.get(j).get(ind2) > ls.get(i).get(ind1)) {
                            cur++;
                            ind1++;
                            prev = 1;
                        } else {
                            ind2++;
                            prev = 0;
                        }
                    }
                }

                ans = Math.max(ans, 1 + cur);
            }
        }

        return ans;
    }
}