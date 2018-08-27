/**
 * 翻转二叉树
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return null; }
        if (root.left == null && root.right == null) { return root; }
        TreeNode tmp = null;
        if (root.left != null) { 
            tmp = root.left; 
            root.left = invertTree(root.right);
            root.right = invertTree(tmp);
        }
        else {
            tmp = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(tmp);
        }
        return root;
    }
}