class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for(String p : word1)
        {
            s.append(p);
        }
        for(String p : word2)
        {
            t.append(p);
        }
        if(s.compareTo(t) == 0)
        {
            return true;
        }
        return false;
    }
}