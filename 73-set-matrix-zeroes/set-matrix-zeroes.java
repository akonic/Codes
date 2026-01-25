class Pair implements Comparable<Pair> {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.first != o.first) {
            return this.first - o.first;
        }
        return this.second - o.second;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        TreeMap<Pair,Integer> mp = new TreeMap<>();

        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0){
                mp.put(new Pair(i,j),1);}
            }
        }
        for(Map.Entry<Pair,Integer> e : mp.entrySet())
        {
            int a=e.getKey().first;
            int b=e.getKey().second;
             for(int i=0;i<m;i++)
             {
                matrix[a][i]=0;
             }
             for(int i=0;i<n;i++)
             {
                matrix[i][b]=0;
             }
        }
    }
}