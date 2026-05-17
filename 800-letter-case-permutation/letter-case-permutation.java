class Solution {
    private void helper(List<String> ls,char[] ch,int i)
    {
        if(i>=ch.length)
        {
            ls.add(new String(ch));
            return ;
        }
        
           if (Character.isUpperCase(ch[i])) {
                ch[i] = Character.toLowerCase(ch[i]);
                helper(ls,ch,i+1);
                ch[i] = Character.toUpperCase(ch[i]);
                helper(ls,ch,i+1);
            } 
            else if (Character.isLowerCase(ch[i])) {
                ch[i] = Character.toUpperCase(ch[i]);
                helper(ls,ch,i+1);
                ch[i] = Character.toLowerCase(ch[i]);
                helper(ls,ch,i+1);
            }
            else{
                helper(ls,ch,i+1);
            }
        
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ls = new ArrayList<>();
        int n=0;
        char[] ch = s.toCharArray();
        // for(int i=0;i<s.length();i++)
        // {
        //     char temp = ch[i];
        //     if(Character.isLetter(temp))
        //     {
        //         System.out.println(temp);
        //     }
        // }
        String p = s;
        helper(ls,ch,0);

        return ls;
    }
}