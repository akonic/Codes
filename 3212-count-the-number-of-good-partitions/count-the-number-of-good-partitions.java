class Solution {
     public static int powerMod(int base, int exponent) {
        int MOD = 1000000007; 
        long result = 1;     
        long b = base % MOD;  // Kept as long for multiplication safety

        while (exponent > 0) {
            // If exponent is odd, multiply b with the result
            if (exponent % 2 == 1) {
                result = (result * b) % MOD;
            }
            
            // Square the base and halve the exponent
            b = (b * b) % MOD;
            exponent = exponent / 2;
        }
        
        return (int) result; // Safely cast back to int
    }
    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=n-1;i>=0;i--)
        {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        //List<Integer> ls = new ArrayList();
        int count=0;
        int i=0,j=0;
        while(i<n && j<n)
        {
            int k = mp.get(nums[i]).get(0);
            //System.out.println(i+" "+j+" "+k);
            int mx=k;
            while(j<mx && j<n)
            {
                j++;
                mx=Math.max( mp.get(nums[j]).get(0),mx);
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