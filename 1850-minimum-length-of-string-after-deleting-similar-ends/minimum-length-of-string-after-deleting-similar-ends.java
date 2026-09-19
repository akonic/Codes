class Solution {
    public int minimumLength(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i=0,j=n-1;
        while(i<j)
        {
            if(ch[i]==ch[j])
            {
                while(i+1<n && ch[i]==ch[i+1])
                {
                    i++;
                }
                while(j-1>=0 && ch[j]==ch[j-1])
                {
                    j--;
                }
                if(i>j)
                {
                    return 0;
                }
                i++;j--;
            }
            else{
                return j-i+1;
            }
        }
        return 1;
    }
}