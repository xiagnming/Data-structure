/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *     1.二叉树的根是数组中的最大元素。
 *     2.左子树是通过数组中最大值左边部分构造出的最大二叉树。
 *     3.右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructMaximumBinaryTree(int[] a, int left, int right) {
        if (left > right) { return null; }
        int val = findMax(a, left, right);
        TreeNode root = new TreeNode(a[val]);
        root.left = constructMaximumBinaryTree(a, left, val - 1);
        root.right = constructMaximumBinaryTree(a, val + 1, right);
        return root;
    }
    
    /**
    * 返回最大元素的下标
    **/
    public int findMax(int[] a, int left, int right) {
        if (left == right) {
            return left;
        }
        int max = a[left];
        int ant = left;
        for (int i = left + 1; i <= right; i++) {
            if (a[i] > max) { 
                max = a[i];
                ant = i;
            }
        }
        return ant;
    }
}