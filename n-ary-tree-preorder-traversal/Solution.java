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
//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
//Given an n-ary tree, return the preorder traversal of its nodes' values.
//        Nary-Tree input serialization is represented in their level order traversal, each group of children
//        is separated by the null value (See examples).
//        Follow up:
//        Recursive solution is trivial, could you do it iteratively?
//        Example 1:
//        Input: root = [1,null,3,2,4,null,5,6]
//        Output: [1,3,5,6,2,4]
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(Node root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        for(Node child: root.children){
            traverse(child, result);
        }
    }
}