class Solution {
public:
    // int fun(vector<int>& cardPoints,int i, int k,int j)
    // {
    //     if(i>j || k==0 )
    //     {
    //         return 0;
    //     }
    //     int a= cardPoints[i] + fun(cardPoints,i+1,k-1,j);
    //     int b=cardPoints[j]+fun(cardPoints,i,k-1,j-1);

    //     return max(a,b);
        
    // }
    int maxScore(vector<int>& cardPoints, int k) {
        int n= cardPoints.size();
        vector<int> v(n,0),u(n,0);
        int c=0;
        for(int i=0;i<n;i++)
        {
            c+=cardPoints[i];
            v[i]=c;
        }
        c=0;
        for(int i=n-1;i>=0;i--)
        {
            c+=cardPoints[i];
            u[i]=c;
        }
        int ans=0;
        for(int i=0;i<=k;i++)
        {  
            if(i==0)
            {
                ans=max(ans,u[n-k-i]);
            }
            else if(i==k)
            {
                ans=max(ans,v[k-1]);
            }
            else{
                ans=max(ans,u[n-(k-i)]+v[i-1]);
            }          
        }
        return ans;
    }
};