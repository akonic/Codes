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
    map<pair<TreeNode*,int>,int> m;
    int fun(TreeNode* node,int taken)
    {
        if(node==nullptr)
        {
            return 0;
        }
        if(m.find({node, taken})!=m.end())
        {
            return m[{node,taken}];
        }
        int take=0,skip=0;
        if(taken==0)
        {
            take = fun(node->left,1) + node->val + fun(node->right,1);
            skip = fun(node->left,0) + fun(node->right,0);
        }
        else{
             skip = fun(node->left,0) + fun(node->right,0); 
        }
        return m[{node,taken}] = max(take,skip);
    }
    int rob(TreeNode* root) {
        return fun(root,0);
    }
};