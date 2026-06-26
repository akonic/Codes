class Solution {
    List<String> ans = new ArrayList<>();
    void dfs(String digits,int i,Map<Integer, List<Character>> mp,String temp)
    {
        if(i==digits.length())
        {
            ans.add(temp);
            return ;
        }

        int x = digits.charAt(i) - '0';
        for(Character p : mp.get(x))
        {
            temp+=p;
            dfs(digits,i+1,mp,temp);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        Map<Integer, List<Character>> mp = new HashMap<>();
        mp.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        mp.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        mp.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        mp.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        mp.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        mp.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        mp.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        mp.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        dfs(digits,0,mp,"");

        return ans;

    }
}