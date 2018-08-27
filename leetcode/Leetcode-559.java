
/**
 * 给定一个N叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点个数。
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null ) { return 0;}
        int res = 1;
        for (Node node : root.children) {
            res = Math.max(res, maxDepth(node) + 1);
        }
        return res;
    }
}