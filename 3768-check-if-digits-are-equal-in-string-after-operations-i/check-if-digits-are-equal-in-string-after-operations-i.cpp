class Solution {
public:
    bool hasSameDigits(string s) {
        string temp;
        while(s.size()>2)
        {
            string temp;
            int n=s.size();
            for(int i=1;i<n;i++)
            {
                temp+=to_string(((s[i-1]-'0') + (s[i]-'0'))%10);
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