class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String, Integer> mp = new HashMap<>();
        char[] ch = s.toCharArray();
        char[] bh = t.toCharArray();
        int n = ch.length;
        int p = n / k;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            temp.append(ch[i]);
            if (temp.length() == p) {
                String u=temp.toString();
                mp.put(u, mp.getOrDefault(u, 0) + 1);
                temp = new StringBuilder();
            }
        }
        temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            temp.append(bh[i]);
            if (temp.length() == p) {
                String u=temp.toString();
                if (mp.containsKey(u)) {
                    if (mp.get(u) > 0) {
                        mp.put(u, mp.getOrDefault(u, 0) - 1);
                        temp = new StringBuilder();
                    } else {
                        return false;
                    }
                }
                else{
                    return false;
                }
                temp = new StringBuilder();
            }
        }
        return true;
    }
}