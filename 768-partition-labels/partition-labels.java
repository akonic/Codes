class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ls  = new ArrayList<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
       int[] last = new int[26];

        for (int i = 0; i < s.length(); i++)
            last[s.charAt(i) - 'a'] = i;

        
        int i=0,j=0;
        while(i<n && j<n)
        {
            int k = last[ch[i]-'a'];
            while(j<n && j<k)
            {
                j++;
                k=Math.max(k,last[ch[j]-'a']);
            }
            if(j==n)
            {
                ls.add(j-i);
            }
            else{
                ls.add(j-i+1);
                i=j;
            }
            i++;j++;
        }
        return ls;
    }
}