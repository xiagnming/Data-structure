/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayBST(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayBST(int[] a, int lo, int hi) {
        if (lo > hi) { return null; }
        if (lo == hi) { return new TreeNode(a[lo]); }
        int mid = (lo + hi) >> 1;
        TreeNode root = new TreeNode(a[mid]);
        root.left = sortedArrayBST(a, lo, mid - 1);
        root.right = sortedArrayBST(a, mid + 1, hi);
        return root;
    }
}