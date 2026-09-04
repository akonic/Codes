class Solution {

    public boolean uniformArray(int[] nums) {


        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        int n= nums.length;
        int c=0,d=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2==1)
            {
                c++;
                minOdd=Math.min(minOdd,nums[i]);
            }
            else{
                d++;
                minEven=Math.min(minEven,nums[i]);
            }
        }
        if(c==n || d==n)
        {
            return true;
        }
        if(minOdd<minEven)
        {
            return true;
        }
        return false;
    }
}