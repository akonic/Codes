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
int rec_knapSack(int W, int wt[], int val[], int n)
{
   if(n==0 || W==0)
   {
       return 0;
   }
   if (wt[n-1] <=W)
   {
       return max(val[n-1]+rec_knapSack(W-wt[n-1],wt,val,n-1),
                  rec_knapSack(W,wt,val,n-1));
   }
   else
   {
       return rec_knapSack(W,wt,val,n-1);
   }

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
        cout<<rec_knapSack(w,wt,val,n)<<endl;

    }
}
