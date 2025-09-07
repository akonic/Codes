class Solution {
public:

    int fun(string s,set<string>& st,int i, vector<int>& v)
    {
        if(i>=s.size())
        {
            return 0;
        }
        if(v[i]!=-1)
        {
            return v[i];
        }
        int ans=INT_MAX;
        string temp;
        for(int k=i;k<s.size();k++)
        {
            int c=0;
            temp+=s[k];
            if(st.find(temp)==st.end())
            {
                c+=temp.size();;
            }
            c+=fun(s,st,k+1,v);
            ans=min(ans,c);
        }
        return v[i]=ans;

    }
    int minExtraChar(string s, vector<string>& dictionary) {
         set<string> st;
        for(int i=0;i<dictionary.size();i++)
        {
            st.insert(dictionary[i]);
        }
        vector<int> v(s.size()+1,-1);
        return fun(s,st,0,v);
    }
};