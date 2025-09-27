class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        int c=0;
        map<int,int> m;
        int n=arr.size();
        vector<int> v;
        for(int i=0;i<n;i++)
        {
            int x = ((arr[i] % k) + k) % k;
            if(x==0)
            {
                c++;
            }
            else {
           v.push_back(x);}
        }
        if(c%2!=0)
        {
            return false;
        }
        sort(v.begin(),v.end());
        int i=0,j=v.size()-1;
        while(i<j)
        {
            if((v[i]+v[j])%k!=0)
            {
                return false;
            }
            i++;j--;
        }
        return true;
    }
};