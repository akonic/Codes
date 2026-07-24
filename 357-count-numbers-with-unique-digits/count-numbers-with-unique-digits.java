class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans=1;
        int[] arr = new int[n+1];
        arr[0]=1;
        for(int i=1;i<=n;i++)
        {
            int p=9;
            int x=i-1;
            int y=9;
            while(x>0)
            {
                y*=p;
                p--;
                x--;
            }
            ans+=y;
        }
        return ans;
    }
}