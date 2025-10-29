class Solution {
public:
    int smallestNumber(int n) {
        int p=1,x=1;
        while(p<n)
        {
            p+=x*2;
            x*=2;
        }
        return p;
    }
};