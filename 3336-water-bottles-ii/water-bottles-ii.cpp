class Solution {
public:
    int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = numBottles, empty = 0;
        int c = 0;
        c += full;
        empty += full;
        full = 0;


        while(empty >= numExchange)
        {
            empty-=numExchange;
            full++;
            numExchange++;

            c+=full;
            empty+=full;
            full=0;

        }
        return c;
    }
};