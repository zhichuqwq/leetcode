/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){return 0;}
        if(root.left == null && root.right == null){return 1;}
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        if(root.left == null || root.right == null){return m1 + m2 + 1;}
        return Math.min(m1 , m2) + 1;
    }
}
