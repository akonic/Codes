class Solution {
    public int longestMountain(int[] arr) {
        int ans=0;
        int n = arr.length;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>arr[i-1])
            {
                int j=i;
                while(j<n && arr[j]>arr[j-1])
                {
                    j++;
                }
                if(j==n)
                {

                }
                else{
                  
                    boolean flag = false;
                    while(j<n && arr[j]<arr[j-1])
                    {
                        flag=true;
                        j++;
                    }
                    if(flag)
                    {
                        ans= Math.max(ans,j-i+1);
                    }
                }
                j=i-1;
                
            }
        }
        return ans;
    }
}