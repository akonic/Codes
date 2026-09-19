class Solution {
     public static int powerMod(int base, int exponent) {
        int MOD = 1000000007; 
        long result = 1;     
        long b = base % MOD; 

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * b) % MOD;
            }
            
            b = (b * b) % MOD;
            exponent = exponent / 2;
        }
        
        return (int) result; 
    }
    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=n-1;i>=0;i--)
        {
           if(!mp.containsKey(nums[i]))
           {
            mp.put(nums[i],i);
           }
        }
        int count=0;
        int j=0;
        for(int i=0;i<n;i++)
        {
            j=Math.max(j,mp.get(nums[i]));
            
            if(j==i)
            {
                count++;
            }
        }
        return powerMod(2,count-1);
    }
}