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
    int ans;
    void fun(TreeNode* node,int left,int right)
    {
        if(node==nullptr)
        {
            return;
        }
        int p=max(abs(node->val - left),abs(node->val - right));
        ans=max(ans,p);
        fun(node->left,min(node->val,left),max(node->val,right));
        fun(node->right,min(node->val,left),max(node->val,right));

    }
    int maxAncestorDiff(TreeNode* root) {
        ans=INT_MIN;
        fun(root,root->val,root->val);
        return ans;
    }
};