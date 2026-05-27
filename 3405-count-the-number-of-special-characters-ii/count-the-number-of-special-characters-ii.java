class Solution {
    public int numberOfSpecialChars(String word) {
         int[] check = new int[26];
         int[] check2 = new int[26];
         int n=word.length();
         Arrays.fill(check,-1);
         Arrays.fill(check2,n);
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch) && check2[Character.toLowerCase(ch)-'a']==n)
            {
                check2[Character.toLowerCase(ch)-'a']=i;
            }
            else if(Character.isLowerCase(ch))
            {
                check[ch-'a']=i;
            }
        }
        for(int i=0;i<26;i++)
        {
            if(check2[i]!=n && check[i]!=-1 && check2[i]>check[i])
            {
                check2[i]=n;
                check[i]=-1;
                ans++;
            }
        }
      
        return ans;
    }
}