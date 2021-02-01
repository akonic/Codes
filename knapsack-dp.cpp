#include<bits/stdc++.h>
#include <algorithm>
#define mod 1000000007
#define ll long long
#define ull unsigned long long
#define f(i,a,n) for(ll i=a;i<n;i++)
#define vec vector<ll>
#define mxh priority_queue<pair<int,int>>
#define mh priority_queue<int,vector<int>,greater<int>>
#define omap map<ll,ll>
#define umap unordered_map<ll,ll>
#define vpair vector<pair<ll,ll> >
#define pb push_back
#define mp make_pair
#define sor(v) sort(v.begin(),v.end())
#define fi  first
#define se second
#define emp empty
//#include <boost/math/common_factor.hpp>

using namespace std;
int DPknapSack(int W, int wt[], int val[], int n)
{
   // Your code here
    int i, w;
    int K[n + 1][W + 1];
    for (i = 0; i <= n; i++)
    {
        for (w = 0; w <= W; w++)
        {
            if (i == 0 || w == 0)
                K[i][w] = 0;
            else if (wt[i - 1] <= w)
                K[i][w] = max(val[i - 1]
                          + K[i - 1][w - wt[i - 1]],
                          K[i - 1][w]);
            else
                K[i][w] = K[i - 1][w];
        }
    }

    return K[n][W];
}
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,w;cin>>n>>w;
        int wt[n],val[n];
        f(i,0,n)
        {
            cin>>val[i];
        }
        f(i,0,n)
        {
            cin>>wt[i];
        }
        cout<<DPknapSack(w,wt,val,n)<<endl;

    }
}
