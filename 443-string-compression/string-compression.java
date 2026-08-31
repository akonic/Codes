class Solution {
    public int compress(char[] chars) {

        StringBuilder s = new StringBuilder();
        int n = chars.length;
        // if(n==1)
        // {
        //     //ch[0]="1";
        //     return 1;
        // }
        int c=1;
        for(int i=1;i<n;i++)
        {
            if(chars[i]==chars[i-1])
            {
                c++;
            }
            else{
                s.append(chars[i-1]);
                if(c>1){
                s.append(c);}
                c=1;
            }
        }
        s.append(chars[n-1]);
        if(c>1){
        s.append(c);}

        for(int i=0;i<s.length();i++)
        {
            chars[i]=s.charAt(i);
        }
        return s.length();
    }
}