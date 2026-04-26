class Solution {
    public String getHint(String secret, String guess) {
        int n=secret.length();
        int a=0,b=0;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            Character ch = secret.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++)
        {
            Character ch = secret.charAt(i);
            Character ch2 = guess.charAt(i);
            if(ch==ch2)
            {
                a++;
                 mp.put(ch,mp.getOrDefault(ch,0)-1);
            }
        }
        for(int i=0;i<n;i++)
        {
            Character ch = secret.charAt(i);
            Character ch2 = guess.charAt(i);
           
                if(ch!=ch2 && mp.containsKey(ch2) && mp.get(ch2)>0)
                {
                    b++;
                    mp.put(ch2,mp.getOrDefault(ch2,0)-1);
                }
        }
        String p = a+"A"+b+"B";
        return p;
    }
}