class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int odd = 0;
        int even = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int comb1 = 1, comb2 = 0;
        boolean flag = false;
        if (nums[0] % 2 == 0) 
            flag = true;
            
        for (int i = 1; i < n; i++) {
                if (flag && nums[i] % 2 == 1) {
                    comb1++;
                    flag = false;
                } else if (flag == false && nums[i] % 2 == 0) {
                    comb1++;
                    flag = true;
                }
            }
        
        return Math.max(comb1,Math.max(odd,even));
    }
}