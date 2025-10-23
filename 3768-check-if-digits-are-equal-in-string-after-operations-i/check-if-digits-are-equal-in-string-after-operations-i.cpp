class Solution {
public:
    bool hasSameDigits(string s) {
        string temp;
        while(s.size()>2)
        {
            vector<int> v;
            int n=s.size();
            for(int i=1;i<n;i++)
            {
                v.push_back(((s[i-1]-'0') + (s[i]-'0'))%10);
            }
            string temp;
            for(auto& i : v)
            {
                temp+=to_string(i);
            }
            s=temp;
        }
        if(s[0]==s[1])
        {
            return true;
        }
        return false;
    }
};