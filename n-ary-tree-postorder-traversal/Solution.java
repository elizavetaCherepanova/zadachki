/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
////Given an n-ary tree, return the postorder traversal of its nodes' values.
////
//        Nary-Tree input serialization is represented in their level order traversal,
//        each group of children is separated by the null value (See examples).
//        Follow up:
//
//        Recursive solution is trivial, could you do it iteratively?
//
//        Input: root = [1,null,3,2,4,null,5,6]
//        Output: [5,6,3,2,4,1]
//        https://leetcode.com/problems/n-ary-tree-postorder-traversal/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        traverse(root, result);
        Collections.reverse(result);
        return result;
    }

    private void traverse(Node root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        for(int i = root.children.size() - 1; i >=0; i--){
            traverse(root.children.get(i), result);
        }

    }
}