class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        int n=letters.size();
        int i=0,j=n;
        while(i<j)
        {
            int mid = i + (j-i)/2;
            if(target<letters[mid])
            {
                j=mid;
            }
            else{
                i=mid+1;
            }
        }
        return letters[i%n];
    }
};