/**
 * 给定一个N叉树，返回其节点值的后序遍历
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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) { return list; }
        Stack<Node> s = new Stack<>();
        s.push(root);
        Node pre = null;
        while (!s.isEmpty()) {
            Node node = s.pop();
            list.add(node.val);
            for (Node n : node.children) {
                s.push(n);
            }
        }
        Collections.reverse(list);
        return list;
    }
}