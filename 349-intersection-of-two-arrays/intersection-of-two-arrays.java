class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ls = new ArrayList<>();
        boolean[] flag = new boolean[1001];
        for (int i : nums1) {
            flag[i] = true;
        }
        for (int i : nums2) {
            if (flag[i]) {
                flag[i] = false;
                ls.add(i);
            }
        }
        int n = ls.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int p = ls.get(i);

            ans[i] = p;

        }
        return ans;
    }
}