class Solution {
public:
    int diff(string s,string p)
    {
        int c=0;
        for(int i=0;i<s.size();i++)
        {
            if(s[i]!=p[i])
            {
                c++;
            }
        }
    return c;
    }
    // long fun(string beginWord, string endWord, vector<string>& wordList,int i)
    // {
    //     if(beginWord==endWord)
    //     {
    //         return 0;
    //     }
    //     if(i>=wordList.size())
    //     {
    //         return INT_MAX;
    //     }
    //     long ans=INT_MAX;
    //     for(int j=i;j<wordList.size();j++)
    //     {
    //         if(diff(wordList[j],beginWord)==1)
    //         {
    //             ans=min(ans, 1 + fun(wordList[j],endWord,wordList,j+1));

    //         }
    //     }
    //     return ans;
    // }
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_map<string,int> m;
         for(int i=0;i<wordList.size();i++)
            {
                m[wordList[i]]=INT_MAX;
            }
        queue<string> q;
        long ans=INT_MAX;
        m[beginWord]=0;
        q.push(beginWord);
        while(!q.empty())
        {
            string p=q.front();
            long cost=m[p];
            q.pop();
            if(p==endWord)
            {
                ans=min(ans,cost);
            }
            for(int i=0;i<wordList.size();i++)
            {
                if(diff(wordList[i],p)==1 && cost+1<m[wordList[i]])
                {
                    m[wordList[i]]=1+cost;
                    q.push(wordList[i]);
                }
            }
        }
        if(ans==INT_MAX)
        {
            return 0;
        }
        return ans+1;
    }
};