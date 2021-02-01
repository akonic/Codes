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
   if(s==0)
   {
       return true;
   }
   if(n==0)
   {
       return false;
   }
   if (a[n-1]<=s)
   {
       return subsetsum(a,n-1,s-a[n-1])||subsetsum(a,n-1,s);
   }
   else
   {
       return subsetsum(a,n-1,s);
   }
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
