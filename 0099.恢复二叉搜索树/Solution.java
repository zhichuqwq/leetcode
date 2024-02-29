/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private Integer prve = null;
    private Integer max = null;
    private TreeNode prvep = null;
    private TreeNode prveroot = null;
    private TreeNode nextroot = null;

    public void recoverTree(TreeNode root) {
        recoverTreett(root);
        prveroot.val = nextroot.val;
        nextroot.val = max;
    }

    public void recoverTreett(TreeNode root){
        if (root == null) {
            return;
        }
        recoverTreett(root.left);
        if (prve != null && prve >= root.val) {
            if (max == null) {
                max = prve;
                prveroot = prvep;
            }
            nextroot = root;
        }
        prvep = root;
        prve = root.val;
        recoverTreett(root.right);
    }
}
