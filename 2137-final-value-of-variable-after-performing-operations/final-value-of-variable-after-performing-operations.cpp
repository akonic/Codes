class Solution {
public:
    int finalValueAfterOperations(vector<string>& operations) {
        int c=0;
        for(auto& i : operations)
        {
            if(i[0]=='-' || i[2]=='-')
            {
                c--;
            }
            else if(i[0]=='+' || i[2]=='+')
            {
                c++;
            }
        }   
        return c;
    }
};