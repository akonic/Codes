class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> ls = new ArrayList<>();
        int n = s.length();
        int count=0,c=0;
        char[] ch = s.toCharArray();
        for(int i=0;i<n;i++)
        {
            if(ch[i]=='0')
            {
                count++;
            }
            else{
                c++;
                if(count>0){
                ls.add(count);}
                count=0;
            }
        }
        if(count>0)
        {
            ls.add(count);
        }
        int ans=0;
        int x=ls.size();
        for(int i=1;i<x;i++)
        {
            int temp=ls.get(i-1)+ls.get(i);
            ans=Math.max(ans,temp);
        }

        


        return ans+c; 
    }
}