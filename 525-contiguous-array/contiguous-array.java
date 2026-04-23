class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,int[]> mp = new HashMap<>();
        int n=nums.length;
        int sum=0;
        mp.put(0, new int[]{0,Integer.MIN_VALUE});
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                sum-=1;
            }
            else{
                sum+=1;
            }
            if(!mp.containsKey(sum))
            {
                mp.put(sum, new int[]{i+1,Integer.MIN_VALUE});
            }
            else{
                int a=mp.get(sum)[0];
                mp.put(sum, new int[]{a,i+1});
            }
             
        }
        int ans=0;
        for (int[] key : mp.values()) {
            if(key[0]!=Integer.MIN_VALUE && key[1]!=Integer.MIN_VALUE){
            ans=Math.max(ans,key[1]-key[0]);}
        }
        return ans;

    }
}