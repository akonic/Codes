class Solution {
    public int romanToInt(String s) {
        TreeMap<Character,Integer> mp = new TreeMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            Character p= s.charAt(i);
            if(p=='I' && i+1<n && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X'))
            {
               ans-=mp.get(p);
               i++;
               ans+=mp.get(s.charAt(i));
            }
            else if(p=='X' && i+1<n && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C'))
            {
               ans-=mp.get(p);
               i++;
               ans+=mp.get(s.charAt(i));
            }
            else if(p=='C' && i+1<n && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M'))
            {
               ans-=mp.get(p);
               i++;
               ans+=mp.get(s.charAt(i));
            }
            else{
                ans+=mp.get(p);
            }
        }
        return ans;
    }
}