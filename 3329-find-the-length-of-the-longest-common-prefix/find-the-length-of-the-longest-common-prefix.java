public class TrieNode{
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode(){
        isEndOfWord=false;
        children = new TrieNode[10];
    }
}


class Solution {

    static void insert(TrieNode root, String key)
    {
        TrieNode curr= root;
        for(char c : key.toCharArray())
        {
            if(curr.children[c-'0']==null)
            {
                TrieNode node = new TrieNode();
                curr.children[c-'0']=node;
            }
            curr = curr.children[c-'0'];
        }
        curr.isEndOfWord=true;
    }
    static int search(TrieNode root,String key)
    {
        TrieNode curr = root;
        int ans=0;
        for(char c : key.toCharArray())
        {
            if(curr.children[c-'0']==null)
            {

                return ans;
            }
            ans++;
            curr=curr.children[c-'0'];
        }
        //curr.isEndofWord;
        return ans;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode trie = new TrieNode();
        for(int i=0;i<arr1.length;i++)
        {
            insert(trie,String.valueOf(arr1[i]));
        }
        int ans=0;
        for(int i=0;i<arr2.length;i++)
        {
            ans=Math.max(ans,search(trie,String.valueOf(arr2[i])));
        }

        return ans;

    }
}