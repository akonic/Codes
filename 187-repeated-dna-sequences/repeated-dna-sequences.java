class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> mp = new HashMap<>();
        int n = s.length();
        List<String> list = new ArrayList<>();
        if (n < 10) {
            return list;
        }
        for (int i = 0; i < n - 9; i++) {
            String k = s.substring(i,i+10);
            mp.put(k, mp.getOrDefault(k, 0) + 1);
        }
        for(Map.Entry<String,Integer> e : mp.entrySet())
        {
            if(e.getValue()>1)
            {
                list.add(e.getKey());
            }
        }
        return list;
    }
}