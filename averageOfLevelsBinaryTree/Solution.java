/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/average-of-levels-in-binary-tree/
//Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//        Example 1:
//        Input:
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        Output: [3, 14.5, 11]
//        Explanation:
//        The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        int level = 0;
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Deque<TreeNode> temp = new LinkedList<>();
            int count = 0;
            long sum = 0;
            while(!queue.isEmpty()){
                root = queue.poll();
                sum += root.val;
                count++;
                if(root.left != null){
                    temp.add(root.left);
                }
                if(root.right != null){
                    temp.add(root.right);
                }
            }
            queue = temp;
            result.add(sum * 1.0 / count);
        }
        return result;
    }
}