class Solution {
public:
    int totalMoney(int n) {
        vector<int> v = {1,2,3,4,5,6,7};
        int c=0,i=0;
        while(n>0)
        {
            c+=v[i];
            v[i]++;
            i++;
            i%=7;
            n--;
        }  
        return c;
    }
};