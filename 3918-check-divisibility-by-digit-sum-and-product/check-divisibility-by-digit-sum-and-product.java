class Solution {
    public boolean checkDivisibility(int n) {
        int x=1,y=0;
        int temp=n;
        while(temp>0)
        {
            y+=temp%10;
            x*=temp%10;
            temp/=10;
        }
        if(n%(y+x)==0)
        {
            return true;
        }
        return false;
    }
}