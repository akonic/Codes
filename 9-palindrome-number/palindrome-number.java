class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        long c=0;
        int temp=x;
        while(temp>0)
        {
            c=c*10 + temp%10;
            temp/=10;
        }
        if(c==(long)x)
        {
            return true;
        }
        return false;

    }
}