class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;
        int maxVal =0;
        for(int i : nums)
        {
            maxVal=Math.max(i,maxVal);
        }

        int[] divisorCount = new int[maxVal+1];
        for(int i=0;i<n;i++)
        {
            int num = nums[i];
            for(int j=1;(long)j*j <=num ;j++)
            {
                if(nums[i]%j==0)
                {
                    divisorCount[j]++;
                    if(num/j!=j)
                    {
                        divisorCount[num/j]++;
                    }
                }
            }
        }

        long[] pairs = new long[maxVal+1];
        for(int i=maxVal;i>=1;i--)
        {
            long count = divisorCount[i];

            pairs[i] =count * (count - 1) / 2;

            for(int j=2*i;j<=maxVal;j+=i)
            {
                pairs[i]-=pairs[j];
            }
        }
        long[] pref = new long[maxVal+1];
        for(int i=1;i<=maxVal;i++)
        {
            pref[i]+=pref[i-1] + pairs[i];
        }
         int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            long idx = queries[q];
            int l = 1;
            int r = maxVal;
            int temp = 1;
            while (l <= r) {
                int mid_gcd = l + (r - l) / 2;

                if (pref[mid_gcd] > idx) {
                    temp = mid_gcd;
                    r = mid_gcd - 1;
                } else {
                    l = mid_gcd + 1;
                }
            }

            result[q] = temp;
        }
        return result;

    }
}