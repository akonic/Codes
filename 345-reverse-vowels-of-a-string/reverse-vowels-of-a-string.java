class Solution {
    private boolean isVowel(char c)
    {
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U' || 
        c=='a' || c=='e' || c=='i' || c=='o' || c=='u' )
        {
            return true;
        }

        return false;
    }
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int j=n-1,i=0;
        while(i<j)
        {
            if(isVowel(ch[i]))
            {
                while(!isVowel(ch[j]))
                {
                    j--;
                }
                char c= ch[i];
                ch[i]=ch[j];
                ch[j]=c;
                j--;
            }
            i++;
        }
        StringBuilder ans = new StringBuilder();
        for(char c : ch)
        {
            ans.append(c);
        }
        return ans.toString();
    }
}