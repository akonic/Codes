class Solution {
    public int missingInteger(int[] nums) {
        int len = 1, sum = 0;
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        sum = nums[0];
        mp.put(nums[0], 1);
        int i=1;
        while(i<n && nums[i]==nums[i-1]+1)
        {
            sum+=nums[i];
            i++;len++;
        }
        for (int j = 1; j < n; j++) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
        }

        while (mp.containsKey(sum)) {
            sum++;
        }

        return sum;

    }
}