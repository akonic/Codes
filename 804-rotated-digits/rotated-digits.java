class Solution {
    public int rotatedDigits(int n) {
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            int temp = i;
            int zero=0,one=0,eight=0,c=0,d=0;
            while(temp>0 && d==0)
            {
                int x=temp%10;
                if( x==3 || x==4 || x==7)
                {
                    d++;
                }
                else if(x==1)
                {
                    one++;
                }
                else if(x==0)
                {
                    zero++;
                }
                else if(x==8)
                {
                    eight++;
                }
                c++;
                temp/=10;
            }
            if(d==0 && c!=one+zero+eight)
            {
                ans++;
            }
        }
        return ans;
    }
}