class Solution {
    public boolean checkString(String s) {
        boolean flag = true;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='b')
            {
                flag=false;
            }
            else if(!flag)
            {
                return false;
            }
        }
        return true;
    }
}