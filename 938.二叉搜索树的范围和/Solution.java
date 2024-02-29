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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){return res;}
        if(root.val <= high && root.val >= low){
            res += root.val;
        }
        rangeSumBST(root.left,low,high);
        rangeSumBST(root.right,low,high);
        return res;
    }
}
