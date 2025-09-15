class Solution {
public:
    int longestPalindrome(string s) {
        map<char,int> m;
        int n=s.size();
        for(int i=0;i<n;i++)
        {
            m[s[i]]++;
        }
        int c=0;
        for(auto& i : m)
        {
            if(i.second%2==1)
            {
                c++;
            }
        }
        if(c==0)
        {
            return n;
        }
        return n-c+1;
    }
};