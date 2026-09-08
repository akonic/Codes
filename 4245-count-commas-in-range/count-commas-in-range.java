class Solution {
    public int countCommas(int n) {
        int len = 0;
        int temp = n;
        while(temp>0)
        {
            len++;
            temp/=10;
        }
        if(len<4)
        {
            return 0;
        }
        int ans=0;
       
        return n-999;
    }
}