/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/sum-of-left-leaves/
//Find the sum of all left leaves in a given binary tree.
//
//        Example:
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root != null){
                if(root.left != null){
                    if( root.left.left == null && root.left.right == null){
                        sum += root.left.val;
                    }
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
            }
        }
        return sum;
    }
}