class Solution {
    public int missingInteger(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = nums[0], n = nums.length;
        int p = Integer.MIN_VALUE, ans = Integer.MAX_VALUE;
         for (int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
         }
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                p = Math.max(p, sum);
                sum = nums[i];
                int a=p;
                while (mp.getOrDefault(a, 0) != 0) {
                    a++;
                }
                return a;
            }

        }
        int a=sum;
        while (mp.getOrDefault(a, 0) != 0) {
                    a++;
                }

        return a;
    }
}