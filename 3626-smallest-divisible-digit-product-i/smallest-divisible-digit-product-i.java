class Solution {
    public int smallestNumber(int n, int t) {
        int ans=0;
        while(true)
        {
            int temp=n;
            int prod=1;
            while(temp>0)
            {
                prod*=temp%10;
                temp/=10;
            }
            if(prod%t==0)
            {
                return n;
            }
            n++;
        }



       // return ans;
    }
}