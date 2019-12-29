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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return false;
        if(root.left !=null && root.right != null){
            if((root.left.val == x && root.right.val == y)
                    || (root.left.val == y && root.right.val == x)) {
                return true;
            }
        }
        if(root.left != null) {
            return isCousins(root.left, x, y);
        }
        if(root.right != null){
            return isCousins(root.right, x, y);
        }
        return false;
    }
}