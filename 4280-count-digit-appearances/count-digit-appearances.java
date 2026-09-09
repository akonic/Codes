class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans=0;
        for(int i : nums)
        {
            int x=i;
            while(x>0)
            {
                if(x%10==digit)
                {
                    ans++;
                }
                x/=10;
            }
        }
        return ans;
    }
}