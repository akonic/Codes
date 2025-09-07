class Solution {
public:
    int fun(string s,set<string>& st,int i, vector<int>& v)
    {
        if(i>=s.size())
        {
            return 1;
        }
        if(v[i]!=-1)
        {
            return v[i];
        }
        string temp;
        for(int k=i;k<s.size();k++)
        {
            temp+=s[k];
            if(st.find(temp)!=st.end() && fun(s,st,k+1,v))
            {
                return v[i]=1;
            }
        }
        return v[i]=0;

    }
    bool wordBreak(string s, vector<string>& wordDict) {
        set<string> st;
        for(int i=0;i<wordDict.size();i++)
        {
            st.insert(wordDict[i]);
        }
        vector<int> v(s.size()+1,-1);
        return fun(s,st,0,v);
    }
};