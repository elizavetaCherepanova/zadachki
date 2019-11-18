/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
//
//        The binary search tree is guaranteed to have unique values.
//        https://leetcode.com/problems/range-sum-of-bst/
class Solution {
    private int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        collectSum(root, L, R);
        return sum;
    }

    private void collectSum(TreeNode root, int l, int r){
        if(root == null) return;
        if (l <= root.val && root.val <= r){
            sum += root.val;
        }
        if(root.val > l){
            collectSum(root.left, l, r);
        }
        if(root.val < r){
            collectSum(root.right, l, r);
        }
    }
}