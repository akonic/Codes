class Solution {
    private int check(int[] ans)
    {
        int c=0;
        for(int i : ans)
        {
            if(i>0)
            {
                c++;
            }
        }
        return c;
    }
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        int n = nums.size();
        for(int i=0;i<n;i++)
        {
            int[] arr = new int[101];
            for(int j=i;j<n;j++)
            {
                arr[nums.get(j)]++;
                int p = check(arr);
               // System.out.println(j+ " "+p);
                ans+=(p*p);
            }
           // System.out.println("------");
        }
        return ans;
    }
}