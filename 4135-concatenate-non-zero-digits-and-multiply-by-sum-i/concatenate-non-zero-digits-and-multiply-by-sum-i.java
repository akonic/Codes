class Solution {
    public static long reverse(long num) {
        long reversed = 0;

        while (num != 0) {
            long digit = num % 10;          
            reversed = reversed * 10 + digit; 
            num /= 10;                     
        }

        return reversed;
    }
    public long sumAndMultiply(int n) {
        int i=0;
        long temp=n;
        long newNo = 0;
        while(temp>0)
        {
            long a=temp%(long)10;
            if(a!=0)
            {
                newNo=newNo*10+a;
            }
            temp/=10;
        }

        temp=newNo;
        int sum=0;
        while(temp>0)
        {
            sum+=temp%10;
            temp/=10;
        }
        long ans=reverse(newNo)*sum;
        return ans;
    }
}