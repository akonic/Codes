class Solution {
    public int longestSubarray(int[] nums) {
        List<int[]> ls = new ArrayList<>();
        int prev = -1;
        int n = nums.length;
        int c = 0;
        boolean f = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (prev == -1) {
                    prev = i;
                }
            } else {
                f = true;
                if (prev != -1) {
                    ls.add(new int[] { prev, i - 1 });
                    prev = -1;
                }
            }
        }
        if (prev != -1) {
            ls.add(new int[] { prev, n - 1 });
        }
        int ans = 0;
        int x = ls.size();

        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            int[] curr = ls.get(0);
            if (f) {
                return curr[1] - curr[0] + 1;
            } else {
                return curr[1] - curr[0];
            }
        }

        for (int i = 1; i < x; i++) {
            int[] p = ls.get(i - 1);
            int[] curr = ls.get(i);
            if (p[1] + 2 == curr[0]) {

                ans = Math.max(ans, p[1] - p[0] + 1 + curr[1] - curr[0] + 1);
            }
            else{
                ans=Math.max(ans,Math.max(p[1]-p[0]+1,curr[1]-curr[0]+1));
            }
        }
        return ans;

    }
}