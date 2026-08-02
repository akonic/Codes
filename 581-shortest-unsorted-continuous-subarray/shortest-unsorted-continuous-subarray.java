class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        for(int i=0;i<n;i++)
        {
            copy[i]=nums[i];
        }
        Arrays.sort(copy);
        int i=0,j=n-1;
        while(i<n && copy[i]==nums[i])
        {
            i++;
        }
        if(i==n)
        {
            return 0;
        }
        while(j>=0 && copy[j]==nums[j])
        {
            j--;
        }
        return j-i+1;
    }
}