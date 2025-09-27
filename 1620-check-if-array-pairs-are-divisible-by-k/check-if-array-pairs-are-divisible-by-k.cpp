class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        int c=0;
        unordered_map<int,int> m;
        int n=arr.size();
        vector<int> v;
        for(int i=0;i<n;i++)
        {
            int x = ((arr[i] % k) + k) % k;
            
            m[x]++;
        }
        if(m[0]%2!=0)
        {
            return false;
        }
       for (int i = 1; i <= k/2; ++i) {
        if (i != k - i) {                   
            if (m[i] != m[k - i]) return false;
        } else {                          
            if (m[i] % 2 != 0) return false;
        }
    }
        return true;
    }
};