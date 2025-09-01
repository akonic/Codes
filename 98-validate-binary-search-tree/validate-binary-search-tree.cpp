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
    bool fun(TreeNode* node,long minVal,long maxVal)
    {
        if(node==nullptr)
        {
            return true;
        }
        if(node->val <= minVal || node->val>=maxVal)
        {
            return false;
        }
        return fun(node->left,minVal,node->val) && fun(node->right,node->val,maxVal);
    }
    bool isValidBST(TreeNode* root) {
        return fun(root,LONG_MIN,LONG_MAX);
    }
};