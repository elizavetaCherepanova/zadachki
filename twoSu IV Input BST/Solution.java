/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Given a Binary Search Tree and a target number, return true if there exist
// two elements in the BST such that their sum is equal to the given target.
//
//        Example 1:
//
//        Input:
//        5
//        / \
//        3   6
//        / \   \
//        2   4   7
//
//        Target = 9
//
//        Output: True
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
class Solution {
    public boolean findTarget(TreeNode root, int target) {
        if(root == null) return false;
        Set<Integer> set = new HashSet<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while(root != null){
            root = queue.poll();
            if(root != null){
                if(set.contains(target - root.val)){
                    return true;
                } else{
                    set.add(root.val);
                }
                if(root.right != null){
                    queue.push(root.right);
                }
                if(root.left != null){
                    queue.push(root.left);
                }
            }
        }
        return false;
    }
}