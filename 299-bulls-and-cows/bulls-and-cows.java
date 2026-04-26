class Solution {
    public String getHint(String secret, String guess) {
        int n=secret.length();
        int a=0,b=0;
        int[] mp = new int[10];
        for(int i=0;i<n;i++)
        {
            Character ch = secret.charAt(i);
            mp[ch-'0']++;
        }
        for(int i=0;i<n;i++)
        {
            Character ch = secret.charAt(i);
            Character ch2 = guess.charAt(i);
            if(ch==ch2)
            {
                a++;
                 mp[ch-'0']--;
            }
        }
        for(int i=0;i<n;i++)
        {
            Character ch = secret.charAt(i);
            Character ch2 = guess.charAt(i);
           
                if(ch!=ch2 && mp[ch2-'0']!=0)
                {
                    b++;
                     mp[ch2-'0']--;
                }
        }
        String p = a+"A"+b+"B";
        return p;
    }
}