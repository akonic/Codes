/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    map<int,int> m;
    int fun(TreeNode* node)
    {
        if(node==nullptr)
        {
            return 0;
        }
        int a=0,b=0;
        if(node->left)
        {
            a=fun(node->left);
        }
        if(node->right)
        {
            b= fun(node->right);
        }
        int sum = node->val+a+b;
        m[sum]++;
        return sum;
    }
    vector<int> findFrequentTreeSum(TreeNode* root) {
        m.clear();
        fun(root);
        vector<int> v;
        int x=INT_MIN;
        for(auto& i : m)
        {
            x=max(x,i.second);
        }
        for(auto& i : m)
        {
            if(i.second==x)
            {
                v.push_back(i.first);
            }
        }
        return v;
    }
};