class Solution {
    private boolean check(int[] nums, int i, int sum1, int sum2, int sum3, int sum4) {
        if (sum1 == 0 && sum2 == 0 && sum3 == 0 && sum4 == 0) {
            return true;
        }
        if(sum1<0 || sum2<0 || sum3<0 || sum4<0)
        {
            return false;
        }
        if(i>=nums.length)
        {
            return false;
        }
        sum1 -= nums[i];
        boolean check1 = check(nums, i + 1, sum1, sum2, sum3, sum4);
        if(check1)
        {
            return true;
        }
        sum1 += nums[i];
        sum2 -= nums[i];
        boolean check2 = check(nums, i + 1, sum1, sum2, sum3, sum4);
        if(check2)
        {
            return true;
        }
        sum2 += nums[i];
        sum3 -= nums[i];
        boolean check3 = check(nums, i + 1, sum1, sum2, sum3, sum4);
        if(check3)
        {
            return true;
        }
        sum3 += nums[i];
        sum4 -= nums[i];
        boolean check4 = check(nums, i + 1, sum1, sum2, sum3, sum4);
        if(check4)
        {
            return true;
        }
        sum4 += nums[i];

        return false;
    }

    public boolean makesquare(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        for(int i : nums)
        {
            if(i>sum/4)
            {
                return false;
            }
        }
        Arrays.sort(nums);
        for(int i=0;i<n/2;i++)
        {
            int x=nums[i];
            nums[i]=nums[n-i-1];
            nums[n-i-1]=x;
        }
        return check(nums, 0, sum / 4, sum / 4, sum / 4, sum / 4);
    }
}