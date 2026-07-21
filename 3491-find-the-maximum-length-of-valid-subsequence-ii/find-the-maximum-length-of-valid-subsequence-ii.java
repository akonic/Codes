class Solution {
    private int helper(List<List<Integer>> ls,int i,int j,int ind1,int ind2,int prev)
    {
        if(ind1>=ls.get(i).size() || ind2>=ls.get(j).size())
        {
            return 0;
        }
        int ans=0;
        if(prev==1)
        {
            if(ls.get(i).get(ind1)>ls.get(j).get(ind2))
            {
                ans= 1 + helper(ls,i,j,ind1,ind2+1,0);
            }
            else{
                ans= helper(ls,i,j,ind1+1,ind2,1);
            }
        }
        else
        {
            if(ls.get(j).get(ind2)>ls.get(i).get(ind1))
            {
                ans= 1 + helper(ls,i,j,ind1+1,ind2,1);
            }
            else{
                ans= helper(ls,i,j,ind1,ind2+1,0);
            }
        }
        return ans;
    }
    public int maximumLength(int[] nums, int k) {
        int n=nums.length;
        List<List<Integer>> ls =new ArrayList<>();
        for(int i=0;i<=k;i++)
        {
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            ls.get(nums[i]%k).add(i);
        }
        int ans=0;
        for(int i=0;i<k;i++)
        {
            ans=Math.max(ans,ls.get(i).size());
            for(int j=i+1;j<k;j++)
            {
                int prev=0;
                int ind1=0,ind2=0;
                if(ls.get(i).size()>0 && ls.get(j).size() >0 && ls.get(i).get(0)>ls.get(j).get(0))
                {
                    prev=1;
                }

                ans=Math.max(ans,1+helper(ls,i,j,ind1,ind2,prev));
            }
        }

        
        return ans;
    }
}