class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0,j=n-1;
        int ans=0;
        while(i<j)
        {
            int a=height[i];
            int b=height[j];
            ans=Math.max(ans,(j-i)*Math.min(a,b));
            if(a>b)
            {
                j--;
            }
            else{
                i++;
            }
        }
        return ans;
    }
}