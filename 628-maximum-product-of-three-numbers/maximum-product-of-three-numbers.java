class Solution {
    public int maximumProduct(int[] nums) {
        int x=-1001,y=-1001,z=-1001;
        for(int i : nums)
        {
            if(i>x)
            {
                z=y;y=x;
                x=i;
            }
            else if(i>y)
            {
                z=y;
                y=i;
            }
            else if(i>z) {
                z=i;
            }
        }
        int a=1001,b=1001;
        for(int i : nums)
        {
            if(i<a)
            {
                b=a;
                a=i;
            }
            else if(i<b)
            {
                b=i;
            }
        }
        return Math.max(x*y*z , a*b*x);
    }
}