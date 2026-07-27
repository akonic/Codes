class Solution {
    public int maxProduct(int[] nums) {
        int x=-1,y=-1;
        for(int i : nums)
        {
            if(i>x)
            {
                y=x;
                x=i;
            }
            else if(i>y){
                y=i;
            }
        }
        return (x-1)*(y-1);
    }
}