class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] check = new boolean[26];
        int ans=0;
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch))
            {
                check[ch-'a']=true;
            }
        }
        for(int i=0;i<n;i++)
        {
            char ch = word.charAt(i);
            char ch2=Character.toLowerCase(ch);
            if(Character.isUpperCase(ch) && check[ch2-'a'])
            {
                check[ch2-'a']=false;
                ans++;
            }
        }
        return ans;
    }
}