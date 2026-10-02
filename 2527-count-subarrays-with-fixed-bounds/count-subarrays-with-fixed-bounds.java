class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        List<Integer> mn = new ArrayList<>(), mx = new ArrayList<>();
        int n = nums.length;
        long ans = 0;
        if (minK > maxK) return 0;
        if (minK == maxK) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == minK) {
                    int j = i;
                    while (j < n && nums[j] == minK) j++;
                    long len = j - i;                    
                    ans += len * (len + 1) / 2;
                    i = j - 1;
                }
            }
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= minK && nums[i] <= maxK) {    
                int start = i, j = i;
                while (j < n && nums[j] >= minK && nums[j] <= maxK) {
                    if (nums[j] == minK) mn.add(j);
                    else if (nums[j] == maxK) mx.add(j);
                    j++;
                }
                j--;
                int a = 0, b = 0, prev = start - 1;     
                while (a < mn.size() && b < mx.size()) {
                    int x = mn.get(a), y = mx.get(b);
                    if (x < y) {
                        ans += (long) (x - prev) * (j - y + 1);
                        prev = x; a++;
                    } else {
                        ans += (long) (y - prev) * (j - x + 1);
                        prev = y; b++;
                    }
                }
                i = j;
                mn.clear(); mx.clear();
            }
        }
        return ans;
    }
}