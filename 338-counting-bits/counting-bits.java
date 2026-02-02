class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            int x=i,c=0;
            while(x>0)
            {
                if(x%2==1)
                {
                    c++;
                }
                x/=2;
            }
            bits[i]=c;
        }
        return bits;
    }
}