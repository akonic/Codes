class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans=0;
        Arrays.sort(people);
        int n = people.length;
        int i=0,j=n-1;
        while(i<=j && i<n && j>=0)
        {
            if(people[i]+people[j]<=limit)
            {
                ans++;
                i++;j--;
            }
            else{
                ans++;j--;
            }
        }
        
        return ans;
    }
}