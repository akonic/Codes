class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i : arr)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int rank = 1;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            mp.put(entry.getKey(), rank);
            rank++;
        }
        for(int i =0 ;i<arr.length;i++)
        {
            arr[i]=mp.get(arr[i]);
        }
        return arr;
    }
}