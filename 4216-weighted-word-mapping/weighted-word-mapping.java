class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String s = "";
        int n=words.length;
        for(int i=0;i<n;i++)
        {
            String temp=words[i];
            int sum=0;
            for(int j=0;j<temp.length();j++)
            {
                char a = temp.charAt(j);
                sum+=weights[a-'a'];
            }
            sum=sum%26;
            char ch = 'z';
            int j=0;
            while(sum>0)
            {
                sum--;
                ch--;
            }
            s+=ch;
        }
    return s;
    }

}