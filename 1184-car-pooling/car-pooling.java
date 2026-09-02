class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int[] i : trips)
        {
            mp.put(i[1],mp.getOrDefault(i[1],0)+i[0]);
            mp.put(i[2],mp.getOrDefault(i[2],0)-i[0]);
        }
        for(int i=0;i<=1000;i++)
        {
            if(mp.containsKey(i))
            {
                capacity-=mp.get(i);
            }
            if(capacity<0)
            {
                return false;
            }
        }
        return true;
    }
}