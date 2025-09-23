class Solution {
public:
    set<string> s;
    bool fun(string word,int i,int j,vector<int>& dp)
    {
       if (i == j) return true; 
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        for (int k = i + 1; k <= j; k++) {  
            if (s.find(word.substr(i, k - i)) != s.end()) {
                if (fun(word, k, j,dp)) {
                    dp[i]=1;
                    return true;
                    }
            }
        }
        dp[i]=0;
        return false;
    }
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        s.clear();
        sort(words.begin(),words.end());
        for(auto& i:words)
        {
            s.insert(i);
        }
        vector<string> v;
        for(auto& i: words)
        {
            s.erase(i);
            int n=i.size();
            vector<int> dp(n+1,-1);
            if (fun(i,0,n,dp)) v.push_back(i);
            s.insert(i);
        }

        return v;

    }
};