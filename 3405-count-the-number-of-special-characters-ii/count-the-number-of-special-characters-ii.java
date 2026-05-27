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
            if (ch >= 'a') {
                check[ch - 'a'] = i;
            } else {
                int p = ch - 'A';
                if (check2[p] == n) check2[p] = i;
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