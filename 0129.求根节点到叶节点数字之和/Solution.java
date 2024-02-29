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
    public int res = 0;
    public int sumNumbers(TreeNode root) {
        sum(root);
        return res;
    }

    public void sum(TreeNode root){
        if(root == null){return;}
        if(root.left != null){root.left.val += 10 * root.val;}
        if(root.right != null){root.right.val += 10 * root.val;}
        if(root.left == null && root.right == null){
            res += root.val;
        }
        sum(root.left);
        sum(root.right);
        }
}
