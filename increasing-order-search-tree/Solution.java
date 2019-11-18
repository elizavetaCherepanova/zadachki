//Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the
//        tree is now the root of the tree, and every node has no left child and only 1 right child.
//        https://leetcode.com/problems/increasing-order-search-tree/
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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> bst = new ArrayList<>();
        composeListFromTree(root, bst);
        int i = 1;
        TreeNode newRoot = new TreeNode(bst.get(0));
        if(bst.size() > 1){
            TreeNode right = new TreeNode(bst.get(i));
            newRoot.right = right;
            i++;
            while(i < bst.size()){
                right.right = new TreeNode(bst.get(i));
                right = right.right;
                i++;
            }
        }
        return newRoot;
    }

    private static void composeListFromTree(TreeNode root, List list){
        if(root == null) return;
        composeListFromTree(root.left, list);
        list.add(root.val);
        composeListFromTree(root.right, list);
    }

}