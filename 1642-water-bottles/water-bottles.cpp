class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int c=numBottles;
        int x=0;
        while(numBottles>=numExchange)
        {
            x=numBottles%numExchange;
            numBottles/=numExchange;
            c+=numBottles;
            numBottles+=x;
        }
        return c;
    }
};