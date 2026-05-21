public class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode(){
        isEndOfWord=false;
        children = new TrieNode[26];
    }
}
class Solution {
        static void insert(TrieNode root, String key)
    {
        TrieNode curr= root;
        for(char c : key.toCharArray())
        {
            if(curr.children[c-'a']==null)
            {
                TrieNode node = new TrieNode();
                curr.children[c-'a']=node;
            }
            curr = curr.children[c-'a'];
        }
        curr.isEndOfWord=true;
    }
    static int search(TrieNode root,String key)
    {
        TrieNode curr = root;
        int ans=0;
        for(char c : key.toCharArray())
        {
            if(curr.children[c-'a']==null)
            {

                return ans;
            }
            ans++;
            curr=curr.children[c-'a'];
        }
        //curr.isEndofWord;
        return ans;
    }
    public String longestCommonPrefix(String[] strs) {
        TrieNode trie = new TrieNode();
        insert(trie,strs[0]);
        int ans= Integer.MAX_VALUE;
        for(int i=1;i<strs.length;i++)
        {
            ans=Math.min(ans,search(trie,strs[i]));
        }
        if(ans==Integer.MAX_VALUE)
        {
            ans=strs[0].length();
        }
        String s="";
        for(int i=0;i<ans;i++)
        {
            s+=strs[0].charAt(i);
        }
        return s;
    }
}