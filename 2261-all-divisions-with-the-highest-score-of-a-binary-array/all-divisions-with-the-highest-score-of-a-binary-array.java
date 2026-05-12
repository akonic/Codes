class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int[] pre0 = new int[n + 1];
        int[] pre1 = new int[n + 1];
        int c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                c++;
            pre0[i + 1] = c;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 1)
                d++;
            pre1[i] = d;
        }
        int x = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            x = Math.max(x, pre0[i] + pre1[i]);
        }
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (pre0[i] + pre1[i] == x)
                ls.add(i);
        }
        return ls;
    }
}