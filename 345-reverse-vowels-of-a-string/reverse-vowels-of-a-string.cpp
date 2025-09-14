class Solution {
public:
    bool isVowel(char c)
    {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' ||
                c == 'U' || c == 'a' || c == 'e' || c == 'i' ||
                c == 'o' || c == 'u')
                {
                    return true;
                }
        return false;
    }
    string reverseVowels(string s) {
        int i=0,j=s.size()-1;
        while(i<j)
        {
            bool a=isVowel(s[i]),b=isVowel(s[j]);
            if( a && b)
            {
                swap(s[i],s[j]);
                i++;j--;
            }
            else if(a)
            {
                j--;
            }
            else{
                i++;
            }


        }
        return s;
    }
};