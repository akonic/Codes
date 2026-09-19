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
        int i=0,j=0;
        while(i<n && j<n)
        {
            int k = mp.get(nums[i]);
            int mx=k;
            while(j<mx && j<n)
            {
                j++;
                mx=Math.max(mx,mp.get(nums[j]));
            }
            if(j==n)
            {
                count++;i++;
            }
            else{
                count++;i=j+1;
                j++;
            }
        }
        return powerMod(2,count-1);
    }
}