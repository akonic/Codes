class Solution {
    public boolean check(int[] temp)
    {
        int x=temp[1]-temp[0];
        int n=temp.length;
        for(int i=2;i<n;i++)
        {
            if(temp[i]-temp[i-1]!=x)
            {
                return false;
            }
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n=l.length;
        List<Boolean> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int[] temp = new int[r[i]-l[i]+1];
            int x=0;
            for(int j=l[i];j<=r[i];j++)
            {
                temp[x]=nums[j];x++;
            }
            Arrays.sort(temp);
            list.add(check(temp));
        }
        return list;
    }
}