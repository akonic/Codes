class Solution {
    public int maxProduct(int n) {
        int x=-1,y=-1;
        int p=n;
        while(p>0)
        {
            int digit = p%10;
            if(digit>x)
            {
                 if(x!=-1)
                {
                    y=x;
                }
                x=digit;
               
            }
            else if(digit>y)
            {
                y=digit;
            }
            p/=10;
        }
        return x*y;
    }
}