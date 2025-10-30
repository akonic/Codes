class Solution {
public:
    // bool fun(int n)
    // {
    //     if(n==1)
    //     {
    //         return false;
    //     }
    //     if(n==2)
    //     {
    //         return true;
    //     }

    // }
    bool divisorGame(int n) {
       if(n%2==0)
       {
        return true;
       }
       return false;
    }
};