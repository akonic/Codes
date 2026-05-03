class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        int m=goal.length();
        if(n!=m)
        {
            return false;
        }
        char[] a1 = s.toCharArray();
        char[] a2 = goal.toCharArray();
        for(int i=0;i<n;i++)
        {
            if(a2[i]==a1[0])
            {
                int j=0,k=i;
                while(j<n)
                {
                    if(a2[(k)%n]==a1[j])
                    {
                        k++;j++;
                    }
                    else {
        break; 
    }
                    
                }
                if(j==n)
                {
                    return true;
                }
            }
        }    
        return false;
    }
}