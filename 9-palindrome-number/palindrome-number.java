class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        List<Integer> ls = new ArrayList();
        int temp = x;
        while(temp>0)
        {
            ls.add(temp%10);
            temp/=10;
        }
        int i=0,j=ls.size()-1;
        while(i<j)
        {
            if(ls.get(i)!=ls.get(j))
            {
                return false;
            }
            i++;j--;
        }
        return true;

    }
}