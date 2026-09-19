class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ls  = new ArrayList<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=n-1;i>=0;i--)
        {
            if(!mp.containsKey(ch[i]))
            {
                mp.put(ch[i],i);
            }
        }
        int i=0,j=0;
        while(i<n && j<n)
        {
            int k = mp.get(ch[i]);
            while(j<n && j<k)
            {
                j++;
                k=Math.max(k,mp.get(ch[j]));
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