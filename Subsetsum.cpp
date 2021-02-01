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
bool subsetsum(ll a[],ll n,ll s)
{
    bool dp[n+1][s+1];
    f(i,0,n+1)
    {
        dp[i][0]=true;
    }
    f(j,1,s+1)
    {
        dp[0][j]=false;
    }
    f(i,1,n+1)
    {
        f(j,1,s+1)
        {
            if(a[i-1]<=s)
            {
                dp[i][j]=dp[i-1][j]||dp[i-1][j-a[i-1]];
            }
            else
            {
                dp[i][j]=dp[i-1][j];
            }

        }
    }
    return dp[n][s];
}
using namespace std;
int main(){
    int t;
    cin>>t;
    while(t--){
        ll n,s;
        cin>>n>>s;
        ll arr[n];
        for(int i = 0;i <n;i++)
            cin>>arr[i];
        if(subsetsum(arr,n,s))
            cout<<"YES\n";
        else
            cout<<"NO\n";
    }
    return 0;
}
