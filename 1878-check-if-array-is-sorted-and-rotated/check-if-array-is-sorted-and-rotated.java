class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int p = nums[0];
        int k = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if(k!=-1)
                {
                    return false;
                }
                k = i;

            }
            
        }
        if(k==-1)
        {
            return true;
        }
        int i = 0;
        while (i <= k) {
            if (nums[i] < p) {
                return false;
            }
            p = Math.max(nums[i], p);
            i++;
        }
        i = k + 1;
        while (i <= k) {
            if (nums[i] < p) {
                return false;
            }
            p = Math.max(nums[i], p);
            i++;
        }
        for(int l=0;l<=k;l++)
        {
            for(int j=k+1;j<n;j++)
            {
                if(nums[l]<nums[j])
                {
                    return false;
                }
            }
        }

        return true;
    }
}