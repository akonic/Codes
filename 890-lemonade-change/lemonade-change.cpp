class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        map<int,int> m;
        for(auto& i: bills)
        {
            if(i==5)
            {
                m[i]++;
            }
            else if(i==10)
            {
                if(m[5]==0)
                {
                    return false;
                }
                else{
                    m[5]--;
                    m[10]++;
                }
            }
            else{
                if(m[10]>=1 && m[5]>=1)
                {
                    m[20]++;
                    m[5]--;
                    m[10]--;
                }
                else if(m[10]<=0 && m[5]>=3)
                {
                    m[5]-=3;
                    m[20]++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
};