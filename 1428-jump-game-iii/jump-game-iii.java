class Solution {
    private boolean helper(int[] arr,int start,int[] visited)
    {
        if(arr[start]==0)
        {
            return true;
        }
        
        boolean a= false,b=false;
        int a1=start+arr[start];
        int b1=start-arr[start];
        if(a1<arr.length && visited[a1]==-1)
        {
            visited[a1]=1;
            a=helper(arr,start+arr[start],visited);
        }
        if(b1>=0 &&  visited[b1]==-1)
        {
            visited[b1]=1;
            b=helper(arr,start-arr[start],visited);
        }
        return a|| b;
        
    }
    public boolean canReach(int[] arr, int start) {
        int[] visited = new int[arr.length];
        Arrays.fill(visited,-1);
        visited[start]=1;
        return helper(arr,start,visited);
    }
}