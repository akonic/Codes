/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* fun(TreeNode* root, TreeNode* p, TreeNode* q)
    {
         if(root==nullptr)
        {
            return root;
        }
        if(root->val  == p->val)
        {
            return root;
        }
        if(root->val == q->val)
        {
            return root;
        }
        TreeNode* left = fun(root->left,p,q);
        TreeNode* right = fun(root->right,p,q);
        if(left && right)
        {
            return root;
        }
        return left?left:right;


    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        return fun(root,p,q);
    }
};