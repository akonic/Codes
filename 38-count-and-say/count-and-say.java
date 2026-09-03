class Solution {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        String p = "1";
        for(int i=2;i<=n;i++)
        {
            char[] ch = p.toCharArray();
            StringBuilder k = new StringBuilder();
            int c=1;
            int j=1;
            while(j<ch.length)
            {
                if(ch[j]==ch[j-1])
                {
                    c++;
                }
                else{
                    k.append(c);
                    k.append(ch[j-1]);
                    c=1;
                }j++;
            }
            k.append(c);
            k.append(ch[j-1]);
            p=k.toString();
        }
        return p;
    }
}