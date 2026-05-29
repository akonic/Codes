class Solution {
    private boolean hasCommon(String a,String b)
    {
        boolean[] arr = new boolean[26];
        for(int i=0;i<a.length();i++)
        {
            char ch = a.charAt(i);
            arr[ch-'a']=true;
        }
        for(int i=0;i<b.length();i++)
        {
            char ch = b.charAt(i);
            if(arr[ch-'a'])
            {
                return true;
            }
        }
        return false;
    }
    public int maxProduct(String[] words) {
        int ans=0;
        int n=words.length;
        //Arrays.sort(words);
        for(int i=n-1;i>=0;i--)
        {
            int len1=words[i].length();
            for(int j=i-1;j>=0;j--)
            {
                int len2=words[j].length();
                if(len1*len2>ans)
                {
                    if(!hasCommon(words[i],words[j]))
                    {
                        ans=len1*len2;
                    }
                }
            }
        }
        return ans;
    }
}