class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        list.add(prev);
        for(int i=2;i<=numRows;i++)
        {
            List<Integer> ls = new ArrayList<>();
            for(int j=0;j<i;j++)
            {
                if(j==0 || j==i-1)
                {
                    ls.add(1);
                }
                else{
                    ls.add(prev.get(j - 1) + prev.get(j));
                }
            }
            list.add(ls);
            prev=ls;
        }
        return list;
        

    }
}