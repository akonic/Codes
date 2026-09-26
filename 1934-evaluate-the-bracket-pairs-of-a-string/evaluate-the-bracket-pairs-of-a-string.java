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
                int j=i+1;
                while(ch[j]!=')')
                {
                    j++;
                }
                String result = s.substring(i+1, j);
                if(mp.containsKey(result)){
                ans.append(mp.get(result));}
                else{
                    ans.append("?");
                }
                i=j;

            }
            else{
                ans.append(ch[i]);
            }
        }
        return ans.toString();
    }
}