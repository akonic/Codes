class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] firstSeen = new int[2 * n + 1]; 
        Arrays.fill(firstSeen, Integer.MIN_VALUE);
        firstSeen[n] = -1; 

        int sum = 0;
        int ans = 0;

        for(int i = 0; i < n; i++)
        {
            sum += nums[i] == 0 ? -1 : 1;

            if(firstSeen[sum + n] != Integer.MIN_VALUE)
            {
                ans = Math.max(ans, i - firstSeen[sum + n]);  
            }
            else
            {
                firstSeen[sum + n] = i;
            }
        }
        return ans;
    }
}