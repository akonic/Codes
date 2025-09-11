class Solution {
public:
    string removeOccurrences(string s, string part) {
        int n=s.size(),m=part.size();
        int j=m-1;
        stack<char> st;
        for(int i=0;i<s.size();i++)
        {
              st.push(s[i]);
          if (st.size() >= m && st.top() == part[m - 1]) {
                int k = m - 1;
                string temp;             
                while (k >= 0 && !st.empty() && st.top() == part[k]) {
                    temp.push_back(st.top());
                    st.pop();
                    --k;
                }
                if (k != -1) {
                    for (int t =temp.size() - 1; t >= 0; --t) {
                        st.push(temp[t]);
                    }
                }
            }
        }
        string p;
        while(!st.empty())
        {
            p.push_back(st.top());st.pop();
        }
        reverse(p.begin(),p.end());
        return p;
    }
};