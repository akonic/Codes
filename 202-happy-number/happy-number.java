class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(true)
        {
            int x=0;
            while(n>0)
            {
                int p=n%10;
                n/=10;
                x+=p*p;
            }
            n=x;
             if(mp.containsKey(n))
            {
                return false;
            }
            
            else if(n==1)
            {
                return true;
            }
            mp.put(n,1);
        }
       
    }
}