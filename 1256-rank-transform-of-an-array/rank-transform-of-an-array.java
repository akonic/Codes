class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();
        int[] copy = arr.clone();
        Arrays.sort(copy);
        int x=1;
        for(int i : copy)
        {
            if(!mp.containsKey(i))
            {
                mp.put(i,x);
                x++;
            }
        }
        for(int i =0 ;i<arr.length;i++)
        {
            arr[i]=mp.get(arr[i]);
        }
        return arr;
    }
}