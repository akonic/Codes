class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> mp = new HashMap<>();
        for(List<String> ls : knowledge)
        {
            mp.put(ls.get(0),ls.get(1));
        }

        char[] ch = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        int n = ch.length;
        for(int i=0;i<n;i++)
        {
            if(ch[i]=='(')
            {
                StringBuilder temp = new StringBuilder();
                i++;
                while(ch[i]!=')')
                {
                    temp.append(ch[i]);
                    i++;
                }
                if(mp.containsKey(temp.toString())){
                ans.append(mp.get(temp.toString()));}
                else{
                    ans.append("?");
                }

            }
            else{
                ans.append(ch[i]);
            }
        }
        return ans.toString();
    }
}