class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        int n=customers.size();
        long long c=0,x=0;
        for(int i=0;i<n;i++)
        {
            if(customers[i][0]>c)
            {
               c=customers[i][1]+customers[i][0];
               x+=customers[i][1];
            }
            else{
                c+=customers[i][1];
                x+=c-customers[i][0];
            }
           
        }
        double p=x*(1.00)/n;
        return p;
    }
};